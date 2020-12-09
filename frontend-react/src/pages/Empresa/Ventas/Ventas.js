import React, { Component } from 'react'
import { Route, Switch } from 'react-router-dom';
import ListaVentas from './ListaVentas/ListaVentas';
import NuevaVenta from './NuevaVenta/NuevaVenta';
import Venta from './Venta/Venta';

export default class Ventas extends Component {

    state = {
        ventas: []
    }
    
    componentDidMount(){
        this.obtenerVentas();
    }

    /* Eventos */
    clickBtnActualizar = () => {
        this.obtenerVentas();
    }

    /* Funciones */
    async obtenerVentas(){
        
        let fetchResult = await fetch("http://localhost:8081/api/ventas");
        let result = await fetchResult.json();

        this.setState({
            ventas: result
        })
    }

    render() {
        return (
            <div>
                <Switch>
                    <Route exact path="/empresa/ventas/">
                        <ListaVentas/>
                    </Route>
                    <Route exact path="/empresa/ventas/nueva-venta">
                        <NuevaVenta/>
                    </Route>
                    <Route exact path="/empresa/ventas/:idVenta">
                        <Venta/>
                    </Route>
                </Switch>
            </div>
        )
    }
}
