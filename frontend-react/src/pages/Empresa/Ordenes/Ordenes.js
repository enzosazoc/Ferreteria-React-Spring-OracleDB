import React, { Component } from 'react'
import { Route, Switch } from 'react-router-dom';
import ListaOrdenes from './ListaOrdenes/ListaOrdenes';
import NuevaOrden from './NuevaOrden/NuevaOrden';
import Orden from './Orden/Orden';

export default class Ordenes extends Component {


    state = {
        ordenes: []
    }

    componentDidMount(){
        this.obtenerPedidos();
    }

    /* Funciones */
    async obtenerPedidos(){
        let fetchResult = await fetch("http://localhost:8081/api/ordenes");
        let result = await fetchResult.json();

        this.setState({
            ordenes: result
        })
    }

    render() {
        return (
            <div>
                <Switch>
                    <Route exact path="/empresa/ordenes/">
                        <ListaOrdenes/>
                    </Route>
                    <Route exact path="/empresa/ordenes/nueva-orden">
                        <NuevaOrden/>
                    </Route>
                    <Route exact path="/empresa/ordenes/:idOrden">
                        <Orden/>
                    </Route>
                </Switch>
            </div>
        )
    }
}
