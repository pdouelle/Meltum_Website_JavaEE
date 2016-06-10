package com.meltum.controller;

import static com.meltum.common.WebConstant.MELTS;
import static com.meltum.common.WebConstant.MELTS_VIEW;
import static com.meltum.common.WebConstant.MELT_FORM;
import static com.meltum.common.WebConstant.REDIRECT_MELT_VIEW;
import static com.meltum.common.WebConstant.SHOPS;
import static com.meltum.common.WebConstant.ZONE_VIEW;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.meltum.beans.Melt;
import com.meltum.common.WebConstant;
import com.meltum.service.IService.IMeltService;
import com.meltum.service.IService.IShopService;

@Controller
@RequestMapping("/melts")
public class MeltsController {

	@Autowired
	private IMeltService meltService = null;
	
	@Autowired
	private IShopService shopService = null;

	@RequestMapping(method = RequestMethod.GET)
	public String displayMelts(Model model, RedirectAttributes redir) {
		model.addAttribute(MELT_FORM, new Melt());
		if (meltService.getMelts() == null) {
			redir.addFlashAttribute("error", "Veuillez cr�er une entreprise afin de pouvoir acc�der aux melts");
			return WebConstant.REDIRECT_MYCOMPANY_VIEW;
		}
		model.addAttribute(MELTS, meltService.getMelts());
		model.addAttribute(SHOPS, shopService.getShops());
		return MELTS_VIEW;
	}
	
	@RequestMapping("/{id}")
	public String displayMeltsByShop(Model model, RedirectAttributes redir, @PathVariable String id) {
		model.addAttribute(MELT_FORM, new Melt());
		model.addAttribute("idShop", id);
		model.addAttribute(MELTS, meltService.getMeltsByShop(id));
		model.addAttribute(SHOPS, shopService.getShops());
		return MELTS_VIEW;
	}
	
	@RequestMapping(value = "/diffusion", method = RequestMethod.GET)
	public String displayDiffusionZone(Model model) {
		return ZONE_VIEW;
	}

	@RequestMapping("/add")
	public String addMelt(@ModelAttribute Melt form, Model model) {
		try {
			meltService.createMelt(form);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return REDIRECT_MELT_VIEW;
	}
	
	@RequestMapping("/remove/{id}")
	public String removeMelt(@ModelAttribute Melt form, @PathVariable String id, Model model) {
		meltService.removeMelt(form);
		return REDIRECT_MELT_VIEW;
	}
	
	@RequestMapping("/edit/{id}")
	public String editMelt(@ModelAttribute Melt form, @PathVariable String id, Model model) {
		try {
			meltService.updateMelt(form);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return REDIRECT_MELT_VIEW;
	}
	
	@RequestMapping("/upload/{id}")
	public String uploadImage(@ModelAttribute Melt form, @PathVariable String id, Model model, @RequestParam MultipartFile file) {
		meltService.uploadImage(id, file);
		return REDIRECT_MELT_VIEW;
	}
	
}
