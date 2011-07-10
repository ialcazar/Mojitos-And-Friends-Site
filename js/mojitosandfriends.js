$(document).ready(start);

function start(){
	initEvents();
	initEffects();
	
}
function initEvents(){
	$("#li-index").click(function(){
		$("section.body section").hide();
		$("#proximamente").slideDown();
		$("#attendees").fadeIn();
		$("#map2").fadeIn();
		$("#twitts").fadeIn();
		
		selectMenuOption("#li-index");
	});
	$("#li-about").click(function(){
		$("section.body section").hide();
		$("#de-que-va-esto").fadeIn();
		
		selectMenuOption("#li-about");
	});
}

function initEffects(){
	$("#proximamente").slideDown("slow");
}
function selectMenuOption(sectionToSelect){
	$("section.content header nav ul li").removeClass("selected");
	$(sectionToSelect).addClass("selected");
	
}

function loadGMaps() { 
	      if (GBrowserIsCompatible()) {
	        var map = new GMap2(document.getElementById("map2"));
			var point = new GLatLng(40.42072, -3.699758);
			map.addOverlay(new GMarker(point));
	        map.setCenter(point, 17);
	        map.openInfoWindow(map.getCenter(),document.createTextNode("El Tigre"));
	      }
}
