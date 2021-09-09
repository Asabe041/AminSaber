/* global i18n */
import React, {Component} from 'react';
import make from './../catalogue/make.json';
import '../services/localizationService';

export class VinSearch extends Component {
    findVin(e){
        var vin = document.getElementById("vin");
        var vinFound=false;
        var p = document.createElement('p');
        var vinNotFound = false;
        var found = document.getElementById("vinFound");
        var notFound = document.getElementById("vinNotFound");
        found.innerHTML="";
        notFound.innerHTML="";
            if(vin.value.length == 3){
                make.Results.map((model) => {
                    if(!vinFound){
                        if(model.id == vin.value){
                            p.textContent = vin.value + i18n("Looking") + model.name;
                            found.appendChild(p);
                            vinFound=true;
                        }
                        else{ 
                            p.textContent = i18n('CantFindVin') + vin.value;
                            notFound.appendChild(p); 
                            vinNotFound = true; 
                        }
                    }
                    
                });
            }
            else{ 
                    make.Results.map((carModel) => {
                        if(carModel.id == vin.value.substring(0,3)){
                            carModel.children.map((carMake) => {
                                if(!vinFound){
                                    if(carMake.id == vin.value){
                                        var p = document.createElement('p');
                                        p.textContent = vin.value + i18n("Looking") + carModel.name + " " + carMake.name;
                                        var found = document.getElementById("vinFound");
                                        found.appendChild(p);
                                        vinFound=true;
                                    }
                                    else{
                                        
                                        var p = document.createElement('p');
                                        p.textContent = i18n('CantFindVin') + vin.value;
                                        var notFound = document.getElementById("vinNotFound");
                                        notFound.appendChild(p);
                                        vinNotFound = true;
                                    }
                                }
                                
                        });
                    }
                    else{
                            vinNotFound = true;
                    }
                });
            if(vinNotFound && !vinFound){
                p.textContent = i18n('CantFindVin')+ vin.value;
                notFound.appendChild(p);
            }
            }   
        }
    render(){
        return(
                <div>
                    <br/>
                        Vin Search <input type="text" id="vin" name="name" placeholder="440" />
                        <br/>
                        <button className="btn btn-primary" onClick={this.findVin} type="submit" form="form">Search</button>
                   
                    <div id="vinFound">

                    </div>
                    <div id="vinNotFound">

                    </div>
                </div>             
        );
    }
}