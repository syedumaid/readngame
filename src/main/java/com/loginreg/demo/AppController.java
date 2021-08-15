package com.loginreg.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "plebeian";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
	model.addAttribute("user", new User());
	
	return "loginpage";
	
}

	@GetMapping("/register")
		public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signuppage";
	}
	
	@PostMapping("/process_register")
		public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		
		return "register_success";		
	}
	
	@GetMapping("/list_users")
		public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers",listUsers);
		return "users";
	}
	
	@GetMapping("/index")
	public String viewIndexPage() {
		
		return "index";
	}
	
	@GetMapping("/ebooks")
	public String viewEbooksPage() {
		
		return "ebooks";
	}
	@GetMapping("/csgo")
	public String viewCSGoPage() {
		
		return "OnlineMultiplayers/CS-GO/csgo.html";
	}
	@GetMapping("/valorant")
	public String viewValorantPage() {
		
		return "OnlineMultiplayers/Valorant/val.html";
	}
	@GetMapping("/pubg")
	public String viewFifaPage() {
		
		return "/PUBG/pubg.html";
	}
	
	@GetMapping("/boruto")
	public String viewBorutoPage() {
		
		return "/Boruto/boruto.html";
	}
	@GetMapping("/warzone")
	public String viewWarzonePage() {
		
		return "/OnlineMultiplayers/cod warzone/warzone.html";
	}
	
	@GetMapping("/apex")
	public String viewApexPage() {
		
		return "/OnlineMultiplayers/Apex/apex.html";
	}
	
	@GetMapping("/fortnite")
	public String viewFortnitePage() {
		return "/OnlineMultiplayers/Fortnite/fortnite.html";
	}
	
	@GetMapping("/minecraft")
	public String viewMinecraftPage() {
		return "/OnlineMultiplayers/Minecraft/mc.html";
	}
	
	@GetMapping("/rocketleague")
	public String viewRocketPage() {
		return "/OnlineMultiplayers/Rocket-League/rl.html";
	}
	
	@GetMapping("/leagueoflegends")
	public String viewLolPage() {
		return "/OnlineMultiplayers/League-of-Legends/lol.html";
	}
	@GetMapping("/Village")
	public String viewVillagePage() {
		return "RecentReleases/ResidentEvil8/re8.html";
	}
	@GetMapping("/LittleNightmares2")
	public String viewLM2page() {
		return "RecentReleases/LittleNightmares2/littlenightmares.html";
	}
	@GetMapping("/ItTakesTwo")
		public String viewItTakesTwo() {
			return "RecentReleases/ItTakeTwo/itTakesTwo.html";
		}
	@GetMapping("/ACValhalla")
		public String viewValhalla() {
			return "RecentReleases/ACValhallaDLC/acvalhalla.html";
	}
	
	@GetMapping("/Hitman3")
		public String viewHitman3() {
			return "RecentReleases/Hitman 3/hitman3.html";
	}
	
	@GetMapping("/MarvelsAvengers")
		public String viewAvengers() {
			return "RecentReleases/MarvelsAvengers/marvelavengers.html";
	}
	@GetMapping("/RedDeadRedemption2")
		public String viewRD2() {
			return "TopRatedGames/Red Dead Redemption 2/rdr2.html";
	}
	@GetMapping("/Witcher3")
		public String viewWitcher() {
			return "TopRatedGames/Witcher 3/witcher 3.html";
	}
	@GetMapping("/SpidermanPS4")
		public String viewSpiderman() {
			return "TopRatedGames/SpidermanPS4/spidermanPS4.html";
	}
	@GetMapping("/Uncharted4")
		public String viewUncharted4() {
			return "TopRatedGames/Uncharted4ThiefsEnd/uncharted4.html";
	}
	@GetMapping("/Bloodborne")
		public String viewBloodborne() {
			return "TopRatedGames/Bloodborne/bb.html";
	}
	@GetMapping("/ResidentEvil2")
		public String viewRE2() {
			return "TopRatedGames/RE 2 Remake/re2.html";
	}
	@GetMapping("/MetalGearPhantom")
		public String viewMGPhantom() {
			return "TopRatedGames/Metal Gear Solid/metal gear solid.html";
	}
	@GetMapping("/GodofWar")
		public String viewGoW() {
			return "TopRatedGames/GodofWar/gow.html";
	}
	@GetMapping("/ACSyndicate")
		public String viewACSyndicate() {
			return "TopRatedGames/ACSyndicate/acsyndicate.html";
	}
	@GetMapping("/CODMW")
		public String viewCODMW() {
			return "TopRatedGames/CODMW2/codmw.html";
	}
	@GetMapping("/LegendofZelda")
		public String viewZelda() {
			return "TopRatedGames/Legendofzelda/legendofzelda.html";
	}
	@GetMapping("/DoomEternal")
		public String viewDoom() {
			return "TopRatedGames/Doom/doom.html";
	}
	@GetMapping("/HaloInfinite")
		public String viewHalo() {
			return "UpcomingGames/Halo-Infinte/haloinfinte.jpg";
	}
//	@GetMapping("/chat")
//		public String viewChat() {
//		
//		return "chat.html";
//	}
	
}

	