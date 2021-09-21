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
		
		return "OnlineMultiplayers/PUBG/pubg.html";
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
	
	@GetMapping("/HaloInfinite")
		public String viewHalo() {
			return "UpcomingGames/Halo-Infinte/haloinfinte.html";
	}
	
	@GetMapping("/uncharted2")
	public String viewMario() {
		return "Classics/Uncharted2-AmongTheives/uncharted.html";
	}
	@GetMapping("/gtasa")
	public String viewGtasa() {
		return "Classics/GTA-SA/gtasa.html";
	}
	@GetMapping("/batman")
	public String viewBatman() {
		return "Classics/Batman-Arkham-City/bac.html";
	}
	@GetMapping("/halo2")
	public String viewHalo2() {
		return "Classics/Halo 2/halo2.html";
	}
	@GetMapping("/darksouls")
	public String viewDark() {
		return "Classics/Dark Souls/darksoul.html";
	}
	@GetMapping("/elderscrolls")
	public String viewElder() {
		return "Classics/Elder Scrolls V Skyrim/es5.html";
	}
	@GetMapping("/gtavc")
	public String viewGtavc() {
		return "Classics/GTA-VC/gtavc.html";
	}
	@GetMapping("/rdr1")
	public String viewRdr1() {
		return "Classics/Red Dead Redemption 1/rdr 1.html";
	}
	@GetMapping("/codmw")
	public String viewCodmw() {
		return "Classics/COD4-MW/cod1.html";
	}
	@GetMapping("/lastofus")
	public String viewLastofus() {
		return "Classics/Last-of-Us/last of us.html";
	}
	@GetMapping("/ac4")
	public String viewAc4() {
		return "Classics/AC Blackflag/acb.html";
	}
	@GetMapping("/re4")
	public String viewRe4() {
		return "Classics/RE 4/re4.html";
	}
	@GetMapping("/back4blood")
	public String viewB4b() {
		return "UpcomingGames/back4blood/Back4Blood.html";
	}
	@GetMapping("/Daysgone")
	public String viewDaysGone() {
		return "UpcomingGames/DaysGOne/DaysGone.html";
	}
	@GetMapping("/deathloop")
	public String viewDeathloop() {
		return "UpcomingGames/deathloop/deathloop.html";
	}
	@GetMapping("/destiny2")
	public String viewDestiny() {
		return "UpcomingGames/destiny2/Destiny2.html";
	}
	@GetMapping("/DoomEternal")
	public String viewDoomEternal() {
		return "UpcomingGames/Doom Eternal/DoomEternal.html";
	}
	@GetMapping("/f1")
	public String viewF1() {
		return "UpcomingGames/f12021/F12021.html";
	}
	@GetMapping("/GodofWar5")
	public String viewGowR() {
		return "UpcomingGames/God of War Ragnarok/GodofWarRagnarok.html";
	}
	@GetMapping("/halo2021")
	public String viewHalo2021() {
		return "UpcomingGames/halo 2021/Haloinfinite.html";
	}
//	@GetMapping("/chat")
//		public String viewChat() {
//		
//		return "chat.html";
//	}
	
	@GetMapping("/OnePiece")
		public String viewOnePiece() {
		return "Books/Paperback/One Piece/onepiece.html";
	}
	@GetMapping("/ThisBrightFuture")
	public String viewThisBrightFuture(){
		return "Books/ComingSoon/This Bright Future/thisbrightfuture.html";
	}
	@GetMapping("/PresidentsDaughter")
	public String viewPrezDaughter() {
		return "Books/ComingSoon/The President's Daughter/thepresidentsdaughter.html";
	}
	@GetMapping("/JujutsuKaisen")
	public String viewJjk() {
		return "Books/ComingSoon/Jujutsu Kaisen/jujutsu.html";
	}
	@GetMapping("/AbandonedDeath")
	public String viewAd() {
		return "Books/ComingSoon/Abandoned Death/abandoneddeath.html";
	}
	@GetMapping("/DemonSlayer")
	public String viewDs() {
		return "Books/ComingSoon/Demon Slayer/demonslayer.html";
	}
	@GetMapping("/MyHeroAcademia")
	public String viewMha() {
		return "Books/ComingSoon/My Hero Academia/myheroacademia.html";
	}
	@GetMapping("/OnceUponABrokenHeart")
	public String viewOuabh() {
		return "Books/ComingSoon/Once Upon A Broken Heart/onceuopnabrokenheart.html";
	}
	@GetMapping("/RebelsKarma")
	public String viewRebelsKarma() {
		return "Books/ComingSoon/Rebels Karma/rebelskarma.html";
	}
	@GetMapping("/ShadowStorm")
	public String viewShadowStorm() {
		return "Books/ComingSoon/Shadow Storm/shadowstorm.html";
	}
	@GetMapping("/TargetAcquired")
	public String viewTargetAcquired() {
		return "Books/ComingSoon/Tom Clancy's Target Acquired/tom.html";
	}
	@GetMapping("/Bortuo")
	public String viewBoruto() {
		return "Books/Paperback/Boruto/sample2.html";
	}
	@GetMapping("/BlackClover")
	public String viewBlackClover() {
		return "Books/Paperback/Black Clover/sample2.html";
	}
	@GetMapping("/CallofNight")
	public String viewCallofNight() {
		return "Books/Paperback/Call of the Night/callofthenight.html";
	}
	@GetMapping("/DrStone")
	public String viewDrStone() {
		return "Books/Paperback/Dr.Stone/drstone.html";
	}
	@GetMapping("/FullMetalAlchemist")
	public String viewFma() {
		return "Books/Paperback/Full Metal Alchemist/fullmetal.html";
	}
	@GetMapping("/Haikyuu")
	public String viewHaikyuu() {
		return "Books/Paperback/Haikyuu/haikyu.html";
	}
	@GetMapping("/Jojo")
	public String viewJojo() {
		return "Books/Paperback/Jojo's Bizzare Adventures Diamond is Unbreakable/jojo.html";
	}
	@GetMapping("/PromiseNeverland")
	public String viewPnl() {
		return "Books/Paperback/The Promised Neverland/thepromised.html";
	}
	@GetMapping("/1984")
	public String viewGerogeOrwell() {
		return "Books/Sci-Fi/1984/1984.html";
	}
	@GetMapping("/Doomsday")
	public String viewDoomsday() {
		return "Books/Sci-Fi/Doomsday Book/doomsdaybook.html";
	}
	@GetMapping("/Dunes")
	public String viewDune() {
		return "Books/Sci-Fi/Dune,The Butlerian Jihad/dune.html";
	}
	@GetMapping("/LordofRings")
	public String viewLordofRings() {
		return "Books/Sci-Fi/The Lord of the Rings/thelord.html";
	}
	@GetMapping("/Martian")
	public String viewMartian() {
		return "Books/Sci-Fi/The Martian/martin.html";
	}
	@GetMapping("/TimeMachine")
	public String viewTimeMachine() {
		return "Books/Sci-Fi/The Time Machine/thetimemachine.html";
	}
	@GetMapping("/Divergent")
	public String viewDivergent() {
		return "Books/Sci-Fi/Divergent/divergent.html";
	}
	@GetMapping("/BeautifulDisaster")
	public String viewBd() {
		return "Books/Romance/Beautiful Diaster/beautifuldisaster.html";
	}
	@GetMapping("/FiftyShades")
	public String viewFiftyShades() {
		return "Books/Romance/Fifty Shades of Grey/fiftyshadesofgrey.html";
	}
	@GetMapping("/Outlander")
	public String viewOutlander() {
		return "Books/Romance/Outlander/outlander.html";
	}
	@GetMapping("/Riverdale")
	public String viewRiverdale() {
		return "Books/Romance/Riverdale/riverdale.html";
	}
	@GetMapping("/AfterCollection")
	public String viewAco() {
		return "Books/Romance/The After Collection/theaftercollection.html";
	}
	@GetMapping("/TheOriginals")
	public String viewOriginals() {
		return "Books/Romance/The Originals/tom.html";
	}
	@GetMapping("/Twilight")
	public String viewTwilight() {
		return "Books/Romance/Twilight/twilight.html";
	}
	@GetMapping("/VampireDiaries")
	public String viewVd() {
		return "Books/Romance/Vampire Diaries/vampirediaries.html";
	}
	@GetMapping("/AndThenThereWereNone")
	public String viewAttwn() {
		return "Books/Mystery/And then there were none/andthentherewere.html";
	}
	@GetMapping("/GodFather")
	public String viewGodfather() {
		return "Books/Mystery/God Father/godfather.html";
	}
	@GetMapping("/MysticRiver")
	public String viewMysticRiver() {
		return "Books/Mystery/Mystic River/mysticriver.html";
	}
	@GetMapping("/ShutterIsland")
	public String viewShutterIsland() {
		return "Books/Mystery/Shutter Island/shutterisland.html";
	}
	@GetMapping("/SherlockHolmes")
	public String viewSherlockHolmes() {
		return "Books/Mystery/THe Complete Sherlock Holmes/thecompletesher.html";
	}
	@GetMapping("/AnnaDressedinBlood")
	public String viewAnna() {
		return "Books/Horror/Anna Dressed in Blood/annadressed.html";
	}
	@GetMapping("/Birdbox")
	public String viewBirdbox() {
		return "Books/Horror/Bird Box/birdbox.html";
	}
	@GetMapping("/GhostStories")
	public String viewGs() {
		return "Books/Horror/Collected Ghost Stories/coolectedghost.html";
	}
	@GetMapping("/Dracula")
	public String viewDracula() {
		return "Books/Horror/Dracula/dracula.html";
	}
	@GetMapping("/Frankenstein")
	public String viewFra() {
		return "Books/Horror/Frankenstein/frakenstein.html";
	}
	@GetMapping("/Exorcist")
	public String viewExo() {
		return "Books/Horror/The Excorsist/theexorcist.html";
	}
}

	