/* global i18n */
import React, {Component} from 'react';
import {NavLink} from 'react-router-dom';
import {Navbar, Nav} from "react-bootstrap";
import '../services/localizationService';

export class Navigation extends Component {
    
    render(){
        return(
            
            //code for navbar inspired from https://www.youtube.com/watch?v=-Fb552R6mVg&list=PLN1yQDPWR2SMcMsO7QzMCC_g_sYr4K76Q&index=22
            
            <Navbar bg="primary" variant="dark">
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav>
        <NavLink className="d-inline p-2 bg-blue text-white" to="/">{i18n('Home')}</NavLink>
                        <NavLink className="d-inline p-2 bg-blue text-white" to="/partSearch" >{i18n('PartSearch')}</NavLink>
                        <NavLink className="d-inline p-2 bg-blue text-white" to="/vinSearch" >{i18n('VinSearch')}</NavLink>
                        <NavLink className="d-inline p-2 bg-blue text-white" to="/howto" >{i18n('howto')}</NavLink>
                        <NavLink className="d-inline p-2 bg-blue text-white" to="/book" >{i18n('Book')}</NavLink>
                        <NavLink className="d-inline p-2 bg-blue text-white" to="/call" >{i18n('Call')}</NavLink>
                    </Nav>
                </Navbar.Collapse>
        </Navbar>
        );
    }
}