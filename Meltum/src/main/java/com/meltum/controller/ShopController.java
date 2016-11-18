package com.meltum.controller;

import static com.meltum.common.WebConstant.*;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.meltum.beans.Coord;
import com.meltum.beans.Melt;
import com.meltum.beans.Shop;
import com.meltum.common.WebConstant;
import com.meltum.service.IService.ICompanyService;
import com.meltum.service.IService.IShopService;

@Controller
@RequestMapping("/ShopsManagement")
public class ShopController {

	@Autowired
	private IShopService shopService = null;

	@Autowired
	private ICompanyService companyService = null;

	@RequestMapping(method = RequestMethod.GET)
	public String displayShops(Model model, RedirectAttributes redir) {
		model.addAttribute(SHOP_FORM, new Shop());
		if (shopService.getShops() == null) {
			redir.addFlashAttribute("error", "Veuillez cr�er une entreprise afin de pouvoir acc�der aux shops");
			return WebConstant.REDIRECT_MYCOMPANY_VIEW;
		}
		model.addAttribute(SHOPS, shopService.getShops());
		model.addAttribute(WebConstant.IMAGES_SHOPS_LINK, WebConstant.API_URL + "images/shop/");
		return null;
	}

	@RequestMapping("AddShop")
	public String AddShop(@ModelAttribute Shop form, Model model) {
		try {
			shopService.createShop(form);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return REDIRECT_SHOP_VIEW;
	}

	@RequestMapping("/EditShop/{id}")
	public String EditShop(@ModelAttribute Shop form, @PathVariable String id, Model model) {
		try {
			shopService.updateShop(form);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return REDIRECT_SHOP_VIEW;
	}

	@RequestMapping("/UploadImageShop/{id}")
	public String UploadShopImage(@ModelAttribute Shop form, @PathVariable String id, Model model,
			@RequestParam List<MultipartFile> file) {
		if (!file.get(0).isEmpty()) {
			shopService.uploadImage(id, file);
		}
		return REDIRECT_SHOP_VIEW;
	}

	@RequestMapping("/RemoveShop/{id}")
	public String RemoveShop(@ModelAttribute Shop form, @PathVariable String id, Model model) {
		shopService.removeShop(form);
		return REDIRECT_SHOP_VIEW;
	}

	@RequestMapping(value = "/diffusion", method = RequestMethod.GET)
	public String displayDiffusionZone(Model model, RedirectAttributes redir) {
		if (companyService.getShopsFromCompany() == null) {
			redir.addFlashAttribute("error", "Vous n'avez enregistr� aucun magasin au pr�alable");
			return WebConstant.REDIRECT_SHOP_VIEW;
		}
		model.addAttribute(WebConstant.SHOP_LIST, companyService.getShopsFromCompany());
		model.addAttribute(WebConstant.SHOP_LIST_TO_JSON_STRING, new JSONArray(companyService.getShopsFromCompany()));
		return ZONE_VIEW;
	}

	@RequestMapping(value = "/diffusion/saveZone/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public String saveZone(@PathVariable String id, @RequestBody List<Coord> points, Model model) {
		Shop shop = shopService.getShopById(id);
		shop.setPol(points);
		try {
			shopService.updateShop(shop);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		return "{}";
	}
}