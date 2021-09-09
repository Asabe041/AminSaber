/* global i18n */
import React, {Component} from 'react';
import './../services/localizationService';

export class Confirmation extends Component {
    render(){
        return(
            //code inspired from https://dev.to/pankajkumar/react-16-datepicker-example-with-react-datepicker-476p
            <div>
                <br/>
                    {i18n('bookingAppoitnment')}
            </div>
        );
    }
}