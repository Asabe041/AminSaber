/* global i18n */
import React from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import {Home} from './components/Home';
import {PartSearch} from './components/PartSearch';
import {VinSearch} from './components/VinSearch';
import {HowTo} from './components/HowTo';
import {Book} from './components/Book';
import {Confirmation} from './components/Confirmation';
import {Navigation} from './components/Navigation';
import {Call} from './components/Call';
import {Lost} from './components/Lost';
import uk from './images/uk.png'
import french from './images/french.png'

import './services/localizationService';

export class App extends React.Component {
  
  changeLanguage = (e) => {
    window.changeLanguage(e.target.dataset.language);
    this.forceUpdate();
}
  render(){
    
    return(
      //code for browser router inspired from https://www.youtube.com/watch?v=oYspSD04HJE&list=PLN1yQDPWR2SMcMsO7QzMCC_g_sYr4K76Q&index=20 
      <BrowserRouter>
        <div className="container">
        <img src={uk} alt="en" data-language="en" style={{width: "5%", padding: "5px"}} onClick={this.changeLanguage} />
        <img src={french} alt="fr" data-language="fr" style={{width: "4%", padding: "5px"}} onClick={this.changeLanguage} />

        <h3 className="m-3 d-flex justify-content-center">
        {i18n('Partners')}
        </h3>

        <Navigation/>

        <Switch>
          <Route path='/' component={Home} exact/>
          <Route path='/partSearch' component={PartSearch} />
          <Route path='/vinSearch' component={VinSearch} />
          <Route path='/howto' component={HowTo} />
          <Route path='/book' component={Book} />
          <Route path='/confirmation' component={Confirmation} />
          <Route path='/call' component={Call} />
          <Route component={Lost}></Route>
        </Switch>
      </div>
    </BrowserRouter>
  );
}
}
export default App;