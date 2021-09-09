	
// Array of products, each product is an object with different fieldset
// A set of ingredients should be added to products		 

var products = [
	{
		name: "apple",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		fruit:true,
		price: 0.99
	},
	{
		name: "tomato",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		fruit: true,
		price: 1.49
	},
	{
		name: "banana",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		fruit: true,
		price: 1.99
	},
	{
		name: "bread",
		vegetarian: true,
		glutenFree: false,
		organic: false,
		fruit: false,
		price: 2.35
	},
	{
		name: "broccoli",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		fruit: false,
		price: 2.49
	},
	{
		name: "kitkat",
		vegetarian: false,
		glutenFree: false,
		organic: false,
		fruit: false,
		price: 2.99
	},
	{
		name: "beyond meat",
		vegetarian: true,
		glutenFree: true,
		organic: false,
		fruit: false,
		price: 8.99
	},
	{
		name: "salmon",
		vegetarian: false,
		glutenFree: true,
		organic: true,
		fruit: false,
		price: 10.00
	},
	{
		name: "cereal",
		vegetarian: true,
		glutenFree: false,
		organic: false,
		fruit: false,
		price: 10.99
	},
	{
		name: "steak",
		vegetarian: false,
		glutenFree: false,
		organic: false,
		fruit: false,
		price: 14.99
	}
];
	


// given restrictions provided, make a reduced list of products
// prices should be included in this list, as well as a sort based on price

function restrictListProducts(prods, restriction) {
	let product_names = [];
	console.log(restriction);
	for (let i=0; i<prods.length; i+=1) {
		if ((restriction == "Vegetarian") && (prods[i].vegetarian == true)){
			if(prods[i].fruit == true){
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
			}
			else{
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
			}
			
		}
		else if ((restriction == "GlutenFree") && (prods[i].glutenFree == true)){
			if(prods[i].fruit == true){
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
			}
			else{
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
			}
		}
		else if ((restriction == "organic") && (prods[i].organic== true)){
			if(prods[i].fruit == true){
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
			}
			else{
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
			}
		}
		else if (restriction == "None"){
			if(prods[i].fruit == true){
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
			}
			else{
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
			}
		}
	}
	return product_names;
}

function restrictMultipleListProducts(prods, restriction) {
	let product_names = [];

	for (let i=0; i<prods.length; i+=1) {
		//Vege and Gluten
		if(restriction[0] == "Vegetarian" && restriction[1] == "GlutenFree"){
			//vege and gluten 
			if ((restriction[0] == "Vegetarian") && (prods[i].vegetarian == true)){
				if((restriction[1] == "GlutenFree") && (prods[i].glutenFree == true)){
					if(prods[i].fruit == true){
						product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
					}
					else{
						product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
					}
				}
			}
		}
		else if(restriction[0] == "Vegetarian" && restriction[1] == "organic"){
			//vege and organic
			if ((restriction[0] == "Vegetarian") && (prods[i].vegetarian == true)){
				if((restriction[1] == "organic") && (prods[i].organic == true)){
					if(prods[i].fruit == true){
						product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
					}
					else{
						product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
					}
				}
			}
		}
		else if(restriction[0] == "GlutenFree" && restriction[1] == "organic"){
		//gluten and organic
			if((restriction[0] == "GlutenFree") && (prods[i].glutenFree == true)){
				if((restriction[1] == "organic") && (prods[i].organic == true)){
					if(prods[i].fruit == true){
						product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
					}
					else{
						product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
					}
				}
			}
		}
		//all 3 
		else if(restriction.length == 3){
			if ((restriction[0] == "Vegetarian") && (prods[i].vegetarian == true)){
				if((restriction[1] == "GlutenFree") && (prods[i].glutenFree == true)){
					if ((restriction[2] == "organic") && (prods[i].organic== true)){
						if(prods[i].fruit == true){
							product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
						}
						else{
							product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
						}
					}
				}
			}
		}
		else if (restriction == "None"){
			if(prods[i].fruit == true){
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + true);
			}
			else{
				product_names.push(prods[i].name + ',' + prods[i].price + ',' + false);
			}
		}
	}
	return product_names;
}

// Calculate the total price of items, with received parameter being a list of products
function getTotalPrice(chosenProducts) {
	totalPrice = 0;
	for (let i=0; i<products.length; i+=1) {
		console.log(chosenProducts.toString());
		if (chosenProducts.indexOf(products[i].name) > -1){
			totalPrice += products[i].price;
		}
	}
	return totalPrice;
}
