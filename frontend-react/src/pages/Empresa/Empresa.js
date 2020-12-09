import React, { Component } from 'react'
import { NavLink, Route, Switch } from 'react-router-dom'
import Ordenes from './Ordenes/Ordenes'
import Ventas from './Ventas/Ventas'

export default class Empresa extends Component {

    render() {

        return (
            <div>
                <div className="col-12 p-2">
                    <ul className="p-0 pt-2">
                        <NavLink to="/empresa/ventas/" className="lista-item" activeClassName="activo"><i className="fas fa-th-list"></i> Ventas</NavLink>
                        <NavLink to="/empresa/ordenes" className="lista-item" activeClassName="activo"><i className="fas fa-truck-loading"></i> Pedidos</NavLink>
                        <NavLink to="/empresa/productos" className="lista-item" activeClassName="activo"><i className="fas fa-boxes"></i> Productos</NavLink>
                        <NavLink to="/empresa/clientes" className="lista-item" activeClassName="activo"><i className="fas fa-users"></i> Clientes</NavLink>
                        <NavLink to="/empresa/proveedores" className="lista-item" activeClassName="activo"><i className="fas fa-address-card"></i> Proveedores</NavLink>
                        <NavLink to="/empresa/empleados" className="lista-item" activeClassName="activo"><i className="fas fa-user"></i> Empleados</NavLink>
                        <NavLink to="/empresa/vendedores" className="lista-item" activeClassName="activo"><i className="fas fa-user-tie"></i> Vendedores</NavLink>
                    </ul>
                </div>

                <div>
                    <Switch>
                        <Route path="/empresa/ventas">
                            <Ventas/>
                        </Route>
                        <Route path="/empresa/ordenes">
                            <Ordenes/>
                        </Route>
                    </Switch>
                </div>
            </div>
        )
    }
}
