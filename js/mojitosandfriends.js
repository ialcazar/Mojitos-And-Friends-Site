$(document).ready(cargar);


function cargar() { 
	if (GBrowserIsCompatible()) { 
		var map2 = new GMap2(document.getElementById("map2")); 
		map2.setCenter(new GLatLng(37.4419, -122.1419), 13); 
	} 
}