$(document).ready(start);

function start(){
	initEvents();
	initEffects();
	
}
function initEvents(){
	$("#li-index").click(function(){
		$("section.body section").hide();
		$("#proximamente").slideDown();
		$("#twitter").fadeIn();
		$("#map2").fadeIn();
		
		$("section.content header nav ul li").removeClass("selected");
		$("#li-index").addClass("selected");
	});
	$("#li-about").click(function(){
		$("section.body section").hide();
		$("#de-que-va-esto").fadeIn();
		
		$("section.content header nav ul li").removeClass("selected");
		$("#li-about").addClass("selected");
	});
}

function initEffects(){
	$("#proximamente").slideDown("slow");
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