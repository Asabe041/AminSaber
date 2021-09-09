/* global i18n */
import React, {Component} from 'react';
import make from './../catalogue/make.json';
import '../services/localizationService';

export class PartSearch extends Component {
    findPart(e){
        var part = document.getElementById("part");
        var p = document.createElement('p');
        var foundPart = false;
        var found = document.getElementById("partFound");
        var notFound = document.getElementById("partNotFound");
        found.innerHTML="";
        notFound.innerHTML="";
        make.Results.map((car) => {
          car.children.map((subcar) => {
                if(!foundPart){
                subcar.Brakes.map((brakes) => {
                    if(part.value == brakes.Pads){
                        p.textContent = part.value + i18n('Looking') + car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else if(part.value == brakes.Rotors){
                        p.textContent = part.value + i18n('Looking') + car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else if(part.value == brakes.Calipers){
                        p.textContent = part.value +i18n('Looking')+ car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else{
                        p.textContent = i18n('CantFind') + part.value + i18n('TryAgain');
                        notFound.appendChild(p);
                    }
                  });
                }
                if(!foundPart){
                  subcar.Body.map((body) => {
                    if(part.value == body.Bumper){
                        p.textContent = part.value +i18n('Looking') + car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else if(part.value == body.Hood){
                        p.textContent = part.value + i18n('Looking') + car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else if(part.value == body.Wing){
                        p.textContent = part.value + i18n('Looking') + car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else{
                        p.textContent = i18n('CantFind') + part.value + i18n('TryAgain');
                        notFound.appendChild(p);
                    }
                   
                  });
                }
                if(!foundPart){
                  subcar.Exhaust.map((exhaust) => {
                    if(part.value == exhaust.Manifold){
                        p.textContent = part.value +i18n('Looking')+ car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else if(part.value == exhaust.Muffler){
                        p.textContent = part.value + i18n('Looking') + car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else if(part.value == exhaust.Converter){
                        p.textContent = part.value + i18n('Looking') + car.name + " " + subcar.name;
                        found.appendChild(p);
                        foundPart = true;
                    }
                    else{
                        p.textContent = i18n('CantFind') + part.value + i18n('TryAgain');
                        notFound.appendChild(p);
                    }
                   
                  });
                }
              
            });
        }); 
    }
    render(){
        return(
                <div>
                    <br/>
                        Part Search <input type="text" id="part" name="name" placeholder="BCD001" />
                        <br/>
                        <button className="btn btn-primary" onClick={this.findPart} type="submit" form="form">Search</button>
                    <div id="partFound">
                    </div>
                    <div id="partNotFound">
                    </div>
                </div>             
        );
    }
}

