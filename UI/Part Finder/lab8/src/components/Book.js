/* global i18n */
import React, {Component} from 'react';
import make from './../catalogue/make.json';
import DatePicker from 'react-datepicker';
import "react-datepicker/dist/react-datepicker.css";
import 'bootstrap/dist/css/bootstrap.min.css';

import './../services/localizationService';

export class Book extends Component {

    constructor (props) {
        super(props)
        this.state = {
        startDate: new Date()
        };
        this.handleChange = this.handleChange.bind(this);
        this.onFormSubmit = this.onFormSubmit.bind(this);
    }
    handleChange(date) {
        this.setState({
        startDate: date
        })
    }

    onFormSubmit(e) {
        e.preventDefault();
        console.log(this.state.startDate)
    }
     
    noWeekends(date) {
        //code inspired from https://stackoverflow.com/questions/44236542/disable-friday-and-saturday-in-datepicker
                    var day = date.getDay();
                    return [(day != 6 && day != 0)];
    }

    handleClick(e) {
        var part = document.getElementById("part");
        var foundPart = false;
        var p = document.createElement('p');
        var notFound = document.getElementById("notFound");
        notFound.innerHTML="";
        make.Results.map((car) => {
            car.children.map((subcar) => {
                  if(!foundPart){
                  subcar.Brakes.map((brakes) => {
                      if(part.value == brakes.Pads){
                         
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else if(part.value == brakes.Rotors){
                          
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else if(part.value == brakes.Calipers){
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else{
                          p.textContent = i18n('cantFindPart');
                          notFound.appendChild(p);   
                      }
                    });
                  }
                  if(!foundPart){
                    subcar.Body.map((body) => {
                      if(part.value == body.Bumper){
                          
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else if(part.value == body.Hood){
                          
                        e.action="/confirmation";
                        foundPart = true;
                      }
                      else if(part.value == body.Wing){
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else{
                        p.textContent = i18n('cantFindPart');
                          notFound.appendChild(p);
                      }
                     
                    });
                  }
                  if(!foundPart){
                    subcar.Exhaust.map((exhaust) => {
                      if(part.value == exhaust.Manifold){
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else if(part.value == exhaust.Muffler){  
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else if(part.value == exhaust.Converter){                       
                        window.location.replace("/confirmation")
                        foundPart = true;
                      }
                      else{
                        p.textContent = i18n('cantFindPart');
                        notFound.appendChild(p);
                      }
                     
                    });
                  }
                
              });
          }); 
    }
    render(){
        return(
            //code inspired from https://dev.to/pankajkumar/react-16-datepicker-example-with-react-datepicker-476p
            <div>
                <div className="text-left">
                    <form onsubmit="return false" action="">
                    <br/>
                        <div className="partNumber">
                            
                        <p>{i18n('PartNum')} <input type="text" id="part" name="name" placeholder="BCD001" /></p>
                           
                        </div>
                        <br/>
                        Date <div className="form-group">
                            <DatePicker
                                selected={ this.state.startDate }
                                onChange={ this.handleChange }
                                dateFormat="MMMM d, yyyy"
                                className="form-control"
                                minDate={ new Date() }
                                beforeShowDay= {this.noWeekends}
                            />
                        </div>
                    <button type="button" onClick={this.handleClick} className="btn btn-primary">{i18n('chooseDate')}</button>
                    <div id="notFound" className="notFound">
                    </div>
                    </form>
                </div>
            </div>
        );
    }
}