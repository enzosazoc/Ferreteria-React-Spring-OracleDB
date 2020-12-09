import React, { Component } from 'react'
import { Link, withRouter  } from 'react-router-dom'

class Venta extends Component {

    state = {
        detallesVenta: [],
        venta: {},
        cantidadProductos: 0
    }

    componentDidMount(){
        this.obtenerDetallesVenta();
        this.obtenerVenta();   
    }

    /* Funciones */
    async obtenerDetallesVenta() {
        let fetchResult = await fetch("http://localhost:8081/api/detallesVentaPorIdVenta/" + this.props.match.params.idVenta);
        let result = await fetchResult.json();
        
        this.setState({
            detallesVenta: result
        })
        this.calcularCantidadProductos();
    }

    async obtenerVenta() {
        let fetchResult = await fetch("http://localhost:8081/api/ventas/" + this.props.match.params.idVenta);
        let result = await fetchResult.json();

        this.setState({
            venta: result
        })
    }

    calcularCantidadProductos() {
        let sum = 0;
        this.state.detallesVenta.forEach(dVenta => {
            sum += dVenta.cantidad
        });
        this.setState({
            cantidadProductos : sum
        })
    }


    render() {
        
        return (
            <div>
                <div className="d-flex flex-wrap">
                    <div className="col-12 p-2">
                        <Link to="/empresa/ventas/">
                            <button type="button" className="btn boton-1 sombra-1 mr-2"><i class="fas fa-th-list"></i> Lista de ventas</button>
                        </Link>
                        <Link to="/empresa/ventas/nueva-venta">
                            <button type="button" className="btn boton-3 sombra-1 mr-2"><i class="fas fa-plus"></i> Nueva venta</button>
                        </Link>
                    </div>

                    <div className="col-12 col-lg-12 p-2">
                        <div className="col-12 p-0 rounded overflow-hidden sombra-1">

                            <div className="bgc-3 border-bottom p-3">
                                <div className="fs-3 fw-2 tc-1"><i className="fas fa-boxes"></i> Productos de la venta</div>
                            </div>

                            <div>

                                <div className="d-flex flex-wrap col-12 mx-auto p-2 bgc-2 justify-content-start">
                                    <div className="p-2 px-3">
                                        <div className="d-flex">
                                            <div className="fs-4 fw-2 tc-1">Número de Venta:</div>
                                            <div className="fs-4 fw-2 tc-2 ml-1">{this.state.venta.idVenta}</div>
                                        </div>
                                    </div>
                                    <div className="p-2 px-3">
                                        
                                        <div className="d-flex">
                                            <div className="fs-4 fw-2 tc-1">Cantidad de productos: </div>
                                            <div className="fs-4 fw-2 tc-2 ml-1">{this.state.cantidadProductos}</div>
                                            
                                        </div>
                                    </div>
                                    <div className="p-2 px-3">
                                        <div className="d-flex">
                                            <div className="fs-4 fw-2 tc-1">Total de Venta:</div>
                                            <div className="fs-4 fw-2 tc-2 ml-1">${this.state.venta.total}</div>
                                        </div>
                                    </div>
                                    
                                </div>

                                <div className="col-12 px-2">
                                    <div className="border-top"></div>
                                </div>


                                <div className="table-responsive col-12 mx-auto p-2 bgc-2">
                                    <table className="table table m-0">
                                        <thead>
                                            <tr>
                                                <th className="fs-5 fw-2 tc-2 border-top-0">Id</th>
                                                <th className="fs-5 fw-2 tc-2 border-top-0">Producto</th>
                                                <th className="fs-5 fw-2 tc-2 border-top-0">Precio Unitario</th>
                                                <th className="fs-5 fw-2 tc-2 border-top-0">Cantidad</th>
                                                <th className="fs-5 fw-2 tc-2 border-top-0">Total</th>
                                            </tr>
                                        </thead>
                                        <tbody className="fs-5 tc-2">
                                            {
                                                this.state.detallesVenta.map( dVenta => {
                                                    return  <tr key={dVenta.idDetalleVenta}>
                                                        <td>{dVenta.idDetalleVenta}</td>
                                                        <td>{dVenta.producto.nombre}</td>
                                                        <td>{dVenta.precioUnitario}</td>
                                                        <td>{dVenta.cantidad}</td>
                                                        <td>{dVenta.total}</td>
                                                    </tr>
                                                })
                                            }
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default withRouter(Venta)