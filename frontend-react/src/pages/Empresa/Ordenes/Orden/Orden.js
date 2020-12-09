import React, { Component } from 'react'
import { Link, withRouter } from 'react-router-dom'

class Orden extends Component {

    state = {
        detallesOrden: [],
        orden: {}
    }

    componentDidMount(){
        this.obtenerDetallesOrden();
        this.obtenerOrden();
    }

    /* Funciones */
    async obtenerDetallesOrden(){
        let fetchResult = await fetch("http://localhost:8081/api/detallesOrdenPorIdOrden/" + this.props.match.params.idOrden);
        let result = await fetchResult.json();
        
        this.setState({
            detallesOrden: result
        })
    }

    async obtenerOrden(){
        let fetchResult = await fetch("http://localhost:8081/api/ordenes/"+ this.props.match.params.idOrden);
        let result = await fetchResult.json();

        this.setState({
            orden: result
        })
    }

    render() {
        return (
            <div>
                <div className="d-flex flex-wrap">
                    <div className="col-12 p-2">
                        <Link to="/empleado/pedidos">
                            <button type="button" className="btn boton-1 sombra-1 mr-2"><i className="fas fa-th-list"></i> Lista de pedidos</button>
                        </Link>
                    </div>
                    
                    <div className="mb-2"></div>

                    <div className="col-12 col-lg-12 p-2">
                        <div className="col-12 p-0 rounded overflow-hidden sombra-1">

                            <div className="bgc-3 border-bottom p-3">
                                <div className="fs-3 fw-2 tc-1"><i className="fas fa-boxes"></i> Productos del pedido</div>
                            </div>

                            <div>
                                <div className="d-flex flex-wrap col-12 mx-auto p-2 bgc-2 justify-content-start">
                                    <div className="p-2 px-3">
                                        <div className="d-flex">
                                            <div className="fs-4 fw-2 tc-1">Número de Venta:</div>
                                            <div className="fs-4 fw-2 tc-2 ml-1">{this.state.orden.idOrden}</div>
                                        </div>
                                    </div>
                                    <div className="p-2 px-3">
                                        
                                        <div className="d-flex">
                                            <div className="fs-4 fw-2 tc-1">Cantidad de productos: </div>
                                            <div className="fs-4 fw-2 tc-2 ml-1"></div>
                                            
                                        </div>
                                    </div>
                                    <div className="p-2 px-3">
                                        <div className="d-flex">
                                            <div className="fs-4 fw-2 tc-1">Total de Venta:</div>
                                            <div className="fs-4 fw-2 tc-2 ml-1">$</div>
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
                                                this.state.detallesOrden.map( dOrden => {
                                                    return  <tr key={dOrden.idDetalleOrden}>
                                                        <td>{dOrden.idDetalleOrden}</td>
                                                        <td>{dOrden.producto.nombre}</td>
                                                        <td>{dOrden.cantidad}</td>
                                                        <td>{dOrden.precioUnitario}</td>
                                                        <td>{dOrden.total}</td>
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

export default withRouter(Orden)