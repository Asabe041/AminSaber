/* global i18n */
import React, {Component} from 'react';
import make from './../catalogue/make.json';
import { Accordion, Card, Button} from "react-bootstrap";
import '../services/localizationService';

export class Home extends Component {
    render(){
        return(
            <div className="MakeModel">
            {/* Code for accordion inspired from https://react-bootstrap.github.io/components/accordion/*/}
                <Accordion>
                    {make.Results.map((model ) => 
                    <Card>
                        <Card.Header>
                            <Accordion.Toggle as={Button} variant="link" eventKey={model.id}>
                                {model.name}
                            </Accordion.Toggle>
                        </Card.Header>
                        <Accordion.Collapse eventKey={model.id}>
                            <Card.Body>
                                <Accordion>
                                    {model.children.map((carMake ) =>
                                    <Card>
                                        <Card.Header>
                                            <Accordion.Toggle as={Button} variant="link" eventKey={carMake.id}>
                                                {carMake.name}
                                            </Accordion.Toggle>
                                        </Card.Header>
                                        <Accordion.Collapse eventKey={carMake.id}>
                                            <Card.Body>
                                                <Accordion>
                                                    <Card>
                                                        <Card.Header>
                                                        <Accordion.Toggle as={Button} variant="link" eventKey="0">
                                                            {i18n('Breaks')}
                                                        </Accordion.Toggle>
                                                        </Card.Header>
                                                        <Accordion.Collapse eventKey="0">
                                                        <Card.Body>
                                                        <Accordion>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="0">
                                                                {i18n('Pads')}
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="0">
                                                                <Card.Body>
                                                                    {carMake.Brakes[0].Pads}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="1">
                                                                {i18n('Rotors') }
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="1">
                                                                <Card.Body>
                                                                {carMake.Brakes[0].Rotors}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="2">
                                                                {i18n('Calipers') }
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="2">
                                                                <Card.Body>
                                                                {carMake.Brakes[0].Calipers}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                        
                                                        </Accordion>
                                                        </Card.Body>
                                                        </Accordion.Collapse>
                                                    </Card>
                                                    <Card>
                                                        <Card.Header>
                                                        <Accordion.Toggle as={Button} variant="link" eventKey="1">
                                                        {i18n('Body') }
                                                        </Accordion.Toggle>
                                                        </Card.Header>
                                                        <Accordion.Collapse eventKey="1">
                                                        <Card.Body>
                                                        <Accordion>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="0">
                                                                {i18n('Bumper')}
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="0">
                                                                <Card.Body>
                                                                {carMake.Body[0].Bumper}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="1">
                                                                {i18n('Hood')}
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="1">
                                                                <Card.Body>
                                                                {carMake.Body[0].Hood}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="2">
                                                                {i18n('Wing')}
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="2">
                                                                <Card.Body>
                                                                {carMake.Body[0].Wing}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                        </Accordion>
                                                        </Card.Body>
                                                        </Accordion.Collapse>
                                                    </Card>
                                                    <Card>
                                                        <Card.Header>
                                                        <Accordion.Toggle as={Button} variant="link" eventKey="2">
                                                        {i18n('Exhaust')}
                                                        </Accordion.Toggle>
                                                        </Card.Header>
                                                        <Accordion.Collapse eventKey="2">
                                                        <Card.Body>
                                                        <Accordion>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="0">
                                                                {i18n('Manifold') }
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="0">
                                                                <Card.Body>
                                                                {carMake.Exhaust[0].Manifold}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="1">
                                                                {i18n('Muffler')}
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="1">
                                                                <Card.Body>
                                                                {carMake.Exhaust[0].Muffler}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                            <Card>
                                                                <Card.Header>
                                                                <Accordion.Toggle as={Button} variant="link" eventKey="2">
                                                               { i18n('Converter')}
                                                                </Accordion.Toggle>
                                                                </Card.Header>
                                                                <Accordion.Collapse eventKey="2">
                                                                <Card.Body>
                                                                {carMake.Exhaust[0].Converter}
                                                                </Card.Body>
                                                                </Accordion.Collapse>
                                                            </Card>
                                                        </Accordion>
                                                        </Card.Body>
                                                        </Accordion.Collapse>
                                                    </Card>
                                                </Accordion>
                                            </Card.Body>
                                        </Accordion.Collapse>
                                    </Card>
                                    )}
                                </Accordion>
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                        )}
                </Accordion>  
            </div>
        );
    }
}

