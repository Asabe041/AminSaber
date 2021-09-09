
// This function is called when any of the tab is clicked
// It is adapted from https://www.w3schools.com/howto/howto_js_tabs.asp



function openInfo(evt, tabName) {

	// Get all elements with class="tabcontent" and hide them
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}

	// Get all elements with class="tablinks" and remove the class "active"
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}

	// Show the current tab, and add an "active" class to the button that opened the tab
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.className += " active";

}


	
// generate a checkbox list from a list of products
// it makes each product name as the label for the checkbos

function populateListProductChoices(slct1, slct2, slct3) {
	
    var s1 = document.getElementById(slct1);
    var s2 = document.getElementById(slct2);
	var s3 = document.getElementById(slct3);
	var opts =[], opt;
	var needToCheck= ['Vegetarian','GlutenFree','organic','None'];
	// s2 represents the <div> in the Products tab, which shows the product list, so we first set it empty
    s2.innerHTML = "";
	s3.innerHTML = "";
	
	//code pour ce loop inspire de https://www.dyn-web.com/tutorials/forms/select/multi-selected.php
	for (var i=0; i < 4; i++){
		opt = document.getElementById(needToCheck[i]).checked;
		if(opt){
			opts.push(needToCheck[i]);
		}
	} 
	var optionArray;
	
	if(opts.length == 0){
		opts.push('None');
		optionArray = restrictListProducts(products, opts[0]);
	}
	if(opts.length == 1){
		optionArray = restrictListProducts(products, opts[0]);
	}
	else{
		optionArray = restrictMultipleListProducts(products, opts);
	}
	// for each item in the array, create a checkbox element, each containing information such as:
	// <input type="checkbox" name="product" value="Bread">
	// <label for="Bread">Bread/label><br>		
	for (i = 0; i < optionArray.length; i++) {
		var productArray = optionArray[i].split(',');
		// create the checkbox and add in HTML DOM
		var checkbox = document.createElement("input");
		checkbox.type = "checkbox";
		checkbox.name = "product";
		checkbox.value = productArray[0];

		var label = document.createElement('label');
		label.htmlFor = productArray[0];
		label.appendChild(document.createTextNode(productArray[0]+ '  ' + productArray[1]));
		
		var image = document.createElement('img');
		image.src = "images/"+productArray[0]+'.jpg';
		image.width = '100';
		image.height = '100';
		
		if(productArray[2] == 'true'){
			s3.appendChild(checkbox);
			s3.appendChild(label);
			s3.appendChild(image);
			s3.appendChild(document.createElement("br"));
		}
		else{
			s2.appendChild(checkbox);
			s2.appendChild(label);
			s2.appendChild(image);
			s2.appendChild(document.createElement("br")); 
		}
		
		
		// create a breakline node and add in HTML DOM
		
		 
	}
	openInfo(event, 'Products');
}
	
// This function is called when the "Add selected items to cart" button in clicked
// The purpose is to build the HTML to be displayed (a Paragraph) 
// We build a paragraph to contain the list of selected items, and the total price

function selectedItems(){
	
	var ele = document.getElementsByName("product");
	var chosenProducts = [];
	
	var c = document.getElementById('displayCart');
	c.innerHTML = "";
	
	// build list of selected item
	var para = document.createElement("P");
	para.innerHTML = "You selected : ";
	para.appendChild(document.createElement("br"));
	for (i = 0; i < ele.length; i++) { 
		if (ele[i].checked) {
			para.appendChild(document.createTextNode(ele[i].value));
			para.appendChild(document.createElement("br"));
			chosenProducts.push(ele[i].value);
		}
	}
		
	// add paragraph and total price
	c.appendChild(para);
	c.appendChild(document.createTextNode("Total Price is " + getTotalPrice(chosenProducts)));
		
}

