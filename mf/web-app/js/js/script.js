$(document).ready(start);

function start(){
	initEvents();
	initEffects();
	
}
function initEvents(){
	$("#li-index").click(function(){
		$("#main section").hide();
		$("#proximamente").slideDown();
		$("#attendees").fadeIn();
		$("#map2").fadeIn();
		$("#twitts").fadeIn();
		
		selectMenuOption("#li-index");
	});
	$("#li-about").click(function(){
		$("#main section").hide();
		$("#de-que-va-esto").fadeIn();
		
		selectMenuOption("#li-about");
	});
}

function initEffects(){
	$("#proximamente").slideDown("slow");
}
function selectMenuOption(sectionToSelect){
	$("#container header nav ul li").removeClass("selected");
	$(sectionToSelect).addClass("selected");
	
}

function loadGMaps() { 
	      if (GBrowserIsCompatible()) {
	        var map = new GMap2(document.getElementById("map2"));
			var point = new GLatLng(40.42072, -3.699758);
			map.addOverlay(new GMarker(point));
	        map.setCenter(point, 17);
			map.addControl(new GSmallMapControl());
			map.addControl(new GMapTypeControl());
	        map.openInfoWindow(map.getCenter(),document.createTextNode("El Tigre"));
	      }
}

