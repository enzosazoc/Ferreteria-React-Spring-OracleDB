import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class ListaOrdenes extends Component {


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
                <div className="col-12 p-2 d-flex justify-content-between align-items-start">
                    <div>
                        <Link to="/empresa/ordenes/nueva-orden">
                            <button type="button" className="btn boton-3 sombra-1 mr-2"><i class="fas fa-plus"></i> Nuevo pedido</button>
                        </Link>
                        <button type="button" className="btn boton-2 sombra-1" onClick={this.clickBtnActualizar}><i className="fas fa-sync-alt"></i> Actualizar lista</button>
                    </div>
                    <div className="d-flex flex-wrap col-3 p-0">
                        <input className="form-control form-control-sm" type="text" placeholder="Buscar"/>
                    </div>
                </div>

                <div className="col-12 p-2">
                    <div className="col-12 p-0 rounded overflow-hidden sombra-1">

                        <div className="bgc-3 tc-c border-bottom p-3">
                            <div className="fs-3 fw-2 tc-1"><i className="far fa-list-alt"></i> Pedidos</div>
                        </div>

                        <div className="table-responsive col-12 mx-auto p-2 bgc-2">
                        
                            <table className="table m-0">
                                <thead>
                                    <tr>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Id</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Fecha Creación</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Total</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Estado</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Fecha Envío</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Empleado</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Proveedor</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0"></th>
                                    </tr>
                                </thead>
                                <tbody className="fs-5 tc-2">
                                    {this.state.ordenes.map( orden => {
                                        return <tr key={orden.idOrden}>
                                            <td>{orden.idOrden}</td>
                                            <td>{orden.fechaCreacion}</td>
                                            <td>{orden.total}</td>
                                            <td>{orden.estado}</td>
                                            <td>{orden.fechaEnvio}</td>
                                            <td>{orden.empleado.nombres}</td>
                                            <td>{orden.proveedor.nombre}</td>
                                            <td><Link to={`/empleado/pedidos/${orden.idOrden}`}>Ver detalle</Link></td>
                                        </tr>
                                    })}
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>

            </div>
        )
    }
}