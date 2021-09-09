/* global i18n */
import React, {Component} from 'react';
import '../services/localizationService';

export class Call extends Component {
render(){
    return(
            <div>
               <p>{i18n("Help")}</p>
            </div>             
    );
}
}