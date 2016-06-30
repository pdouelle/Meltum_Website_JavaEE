package com.meltum.common;

public interface WebConstant {

	// Views
	public static final String MYACCOUNT_VIEW = "myAccount";
	public static final String CHANGE_PASSWORD_VIEW = "changePassword";
	public static final String LOGIN_VIEW = "login";
	public static final String INSCRIPTION_VIEW = "inscription";
	public static final String HOME_VIEW = "home";
	public static final String MELTS_VIEW = "melts";
	public static final String SHOPS_VIEW = "shops";
	public static final String MY_COMPANY_SHOW_VIEW = "myCompanyShow";
	public static final String MY_COMPANY_EDIT_VIEW = "myCompanyEdit";
	public static final String ZONE_VIEW = "zone";

	// Forms
	public static final String REGISTER_FORM = "registerForm";
	public static final String MYACCOUNT_FORM = "myAccountForm";
	public static final String MYCOMPANY_FORM = "myCompanyForm";
	public static final String MELT_FORM = "meltForm";
	public static final String SHOP_FORM = "shopForm";
	public static final String CHANGE_PASSWORD_FORM = "changePasswordForm";
	
	// Objects
	public static final String MELTS = "melts";
	public static final String SHOPS = "shops";
	public static final String SHOP_LIST = "shopList";
	public static final String SHOP_LIST_TO_JSON_STRING = "shopListJson";

	// Redirect
	public static final String REDIRECT_HOME_VIEW = "redirect:/";
	public static final String REDIRECT_MYACCOUNT_VIEW = "redirect:/mon-compte";
	public static final String REDIRECT_MYCOMPANY_VIEW = "redirect:/mon-entreprise";
	public static final String REDIRECT_MELT_VIEW = "redirect:/melts";
	public static final String REDIRECT_SHOP_VIEW = "redirect:/shops";
	
	// Miscellaneous
	//public static final String API_URL = "http://185.83.218.101:8082/";
	//public static final String API_URL = "http://185.83.218.101:8081/";
	public static final String API_URL = "http://185.83.218.101:8090/";
	//public static final String API_URL = "http://localhost:8080/meltumApi/";
	public static final String EMPTY_STRING = "";
}