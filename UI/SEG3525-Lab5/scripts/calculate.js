function addToCart(service, cart) {
    var s1 = document.getElementById(cart);
    s1.innerHTML="";
    var servicePriceId;
    servicePriceId = service+"-price";
    var s2 = document.getElementById(servicePriceId)

    var s3 = document.getElementById('total');
    s3.innerHTML = s2.innerHTML;
    var p = document.createElement('p');

    var s = document.createElement('span');
    s.className= "price";
    s.innerHTML= s2.innerHTML;

    p.innerHTML = service;
    p.appendChild(s);
    s1.appendChild(p);
}

//code inspired from https://stackoverflow.com/questions/15757918/disable-past-dates-on-datepicker

  function changeDates(mechanic){
    $( "#datepicker" ).datepicker({
        minDate: 0,
        beforeShowDay: function(date){
            if(mechanic == "Erwind"){
                var day = date.getDay();
                return [(day != 4 && day != 5 && day != 6 && day != 0)];
            }
            if(mechanic == "Jane"){
                var day = date.getDay();
                return [(day != 6 && day != 0)];
            }
            if(mechanic == "Albert"){
                var day = date.getDay();
                return [(day != 1 && day != 5 && day != 6 && day != 0)];
            }
        }
       });
  }
