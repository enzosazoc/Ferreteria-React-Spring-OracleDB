import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class ListaVentas extends Component {

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
                <div className="col-12 p-2 d-flex justify-content-between align-items-start">
                    <div>
                        <Link to="/empresa/ventas/nueva-venta">
                            <button type="button" className="btn boton-3 sombra-1 mr-2"><i class="fas fa-plus"></i> Nueva venta</button>
                        </Link>
                        <button type="button" className="btn boton-2 sombra-1" onClick={this.clickBtnActualizar}><i class="fas fa-sync-alt"></i> Actualizar lista</button>
                    </div>
                    {<div className="d-flex flex-wrap col-3 p-0">
                        <input className="form-control form-control-sm" type="text" placeholder="Buscar"/>
                    </div>}
                </div>

                <div className="col-12 p-2">
                    <div className="col-12 p-0 rounded overflow-hidden sombra-1">

                        <div className="bgc-3 tc-c border-bottom p-3">
                            <div className="fs-3 fw-2 tc-1"><i class="far fa-list-alt"></i> Ventas</div>
                        </div>

                        <div className="table-responsive col-12 mx-auto p-2 bgc-2">
                        
                            <table className="table m-0">
                                <thead>
                                    <tr>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Id</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Total</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Estado</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0">Fecha</th>
                                        <th className="fs-5 fw-2 tc-2 border-top-0"></th>
                                    </tr>
                                </thead>
                                <tbody className="fs-5 tc-2">
                                    {
                                        this.state.ventas.map( venta => {
                                            return  <tr key={venta.idVenta}>
                                                <td>{venta.idVenta}</td>
                                                <td>{venta.total}</td>
                                                <td>{venta.estado}</td>
                                                <td>{venta.fecha}</td>
                                                <td><Link to={`/empresa/ventas/${venta.idVenta}`}>Ver detalle</Link></td>
                                            </tr>
                                        })
                                    }
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        )
    }
}
