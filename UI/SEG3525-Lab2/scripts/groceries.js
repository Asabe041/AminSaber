	
// Array of products, each product is an object with different fieldset
// A set of ingredients should be added to products		 

var products = [
	{
		name: "apple",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		price: 0.99
	},
	{
		name: "tomato",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		price: 1.49
	},
	{
		name: "banana",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		price: 1.99
	},
	{
		name: "bread",
		vegetarian: true,
		glutenFree: false,
		organic: false,
		price: 2.35
	},
	{
		name: "brocoli",
		vegetarian: true,
		glutenFree: true,
		organic: true,
		price: 2.49
	},
	{
		name: "kitkat",
		vegetarian: false,
		glutenFree: false,
		organic: false,
		price: 2.99
	},
	{
		name: "beyond-meat burger",
		vegetarian: true,
		glutenFree: true,
		organic: false,
		price: 8.99
	},
	{
		name: "salmon",
		vegetarian: false,
		glutenFree: true,
		organic: true,
		price: 10.00
	},
	{
		name: "cereal",
		vegetarian: true,
		glutenFree: false,
		organic: false,
		price: 10.99
	},
	{
		name: "steak",
		vegetarian: false,
		glutenFree: false,
		organic: false,
		price: 14.99
	}
];
	


// given restrictions provided, make a reduced list of products
// prices should be included in this list, as well as a sort based on price

function restrictListProducts(prods, restriction) {
	let product_names = [];
	
	for (let i=0; i<prods.length; i+=1) {
		if ((restriction == "Vegetarian") && (prods[i].vegetarian == true)){
			product_names.push(prods[i].name + ',' + prods[i].price);
		}
		else if ((restriction == "GlutenFree") && (prods[i].glutenFree == true)){
			product_names.push(prods[i].name + ',' + prods[i].price);
		}
		else if ((restriction == "organic") && (prods[i].organic== true)){
			product_names.push(prods[i].name + ',' + prods[i].price);
		}
		else if (restriction == "None"){
			product_names.push(prods[i].name + ',' + prods[i].price);
		}
	}
	return product_names;
}

function restrictMultipleListProducts(prods, restriction) {
	let product_names = [];
	for (let i=0; i<prods.length; i+=1) {
		
		//Vege and Gluten
		if(restriction[0].value == "Vegetarian" && restriction[1].value == "GlutenFree"){
			//vege and gluten 
			if ((restriction[0].value == "Vegetarian") && (prods[i].vegetarian == true)){
				if((restriction[1].value == "GlutenFree") && (prods[i].glutenFree == true)){
					product_names.push(prods[i].name + ',' + prods[i].price);
				}
			}
		}
		else if(restriction[0].value == "Vegetarian" && restriction[1].value == "organic"){
			//vege and organic
			if ((restriction[0].value == "Vegetarian") && (prods[i].vegetarian == true)){
				if((restriction[1].value == "organic") && (prods[i].organic == true)){
					product_names.push(prods[i].name + ',' + prods[i].price);
				}
			}
		}
		else if(restriction[0].value == "GlutenFree" && restriction[1].value == "organic"){
		//gluten and organic
			if((restriction[0].value == "GlutenFree") && (prods[i].glutenFree == true)){
				if((restriction[1].value == "organic") && (prods[i].organic == true)){
					product_names.push(prods[i].name + ',' + prods[i].price);
				}
			}
		}
		//all 3 
		else if(restriction.length == 3){
			if ((restriction[0].value == "Vegetarian") && (prods[i].vegetarian == true)){
				if((restriction[1].value == "GlutenFree") && (prods[i].glutenFree == true)){
					if ((restriction[2].value == "organic") && (prods[i].organic== true)){
						product_names.push(prods[i].name + ',' + prods[i].price);
					}
				}
			}
		}
		else if (restriction == "None"){
			product_names.push(prods[i].name + ',' + prods[i].price);
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
