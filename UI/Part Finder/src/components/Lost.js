/* global i18n */
import React, {Component} from 'react';
import '../services/localizationService';

export class Lost extends Component {
render(){
    return(
            <div>
               <p>{i18n("Lost")}</p>
            </div>             
    );
}
}