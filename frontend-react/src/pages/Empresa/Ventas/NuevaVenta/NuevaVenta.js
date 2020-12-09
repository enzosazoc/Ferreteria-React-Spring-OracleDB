import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class NuevaVenta extends Component {

    state = {
        venta: {},
        detallesVenta: [],
        productos: []
    }

    componentDidMount(){
        this.obtenerProductos();
    }

    /* Eventos */
    onSubmit = (e) => {
        e.preventDefault();
        this.guardarVenta();
    }

    /* onChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value
        })
    } */

    /* Funciones */
    async obtenerProductos(){
        let fetchResult = await fetch('http://localhost:8081/api/productos');
        let result = await fetchResult.json();
        
        this.setState({
            productos: result
        })
    }
    
    async guardarVenta(){
        try {
            
            let venta = {};
            let ventaDetalle = {};

            venta.total = this.state.venta.total;
            venta.estado = 'Realizada';

            ventaDetalle.venta = venta;
            ventaDetalle.detallesVenta = this.state.detallesVenta;

            let fetchResult = await fetch('http://localhost:8081/api/ventaDetalle', {
                method: 'POST',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(ventaDetalle)
            })

            let result = await fetchResult.json();

            console.log(result)
            console.log(fetchResult.status)
            
        } catch (error) {
            console.log("Error al guardar venta:", error)
        }
    }

    agregarProducto = (pro) => {
        
        let lista = this.state.detallesVenta;

        let detalleVenta = {};

        detalleVenta.cantidad = 1;
        detalleVenta.precioUnitario = pro.precio;
        detalleVenta.total = pro.precio * detalleVenta.cantidad;
        detalleVenta.producto = pro;

        lista.push(detalleVenta)

        this.setState({
            detallesVenta: lista
        })

        this.calcular();
    }

    actualizarProducto = (value, pro) => {

        let lista = this.state.detallesVenta;

        lista.forEach(p => {
            if(p === pro){
                p.cantidad = value;
            }
        });
        
        this.setState({
            detallesVenta: lista
        })

        this.calcular();
    }

    eliminarProducto = (pro) => {

        let lista = this.state.detallesVenta;

        lista.forEach( (p,i) => {
            
            if(p === pro){
                lista.splice(i,1)
            }
        });

        this.setState({
            detalleVenta: lista
        })
    }

    calcular(){

        let detallesVenta = this.state.detallesVenta;
        let ven = {};
        let total = 0;

        detallesVenta.forEach( detVen => {
            
            detVen.total = detVen.cantidad * detVen.precioUnitario
            
            total += detVen.total
        });
        
        ven.total = total;

        this.setState({
            venta: ven
        })
    }

    /* Render */
    render() {

        const productos = {
            maxHeight: "400px",
            height: "400px",
        }
        const tabla = {
            minHeight: "200px",
            maxHeight: "400px",
            height: "400px"
        }

        return (
            <div>
                <div className="col-12 p-2 d-flex justify-content-between align-items-start">
                    <div>
                        <Link to="/empresa/ventas/">
                            <button type="button" className="btn boton-1 sombra-1 mr-2"><i class="fas fa-th-list"></i> Lista de ventas</button>
                        </Link>
                    </div>
                </div>
                <form onSubmit={this.onSubmit} className="p-0 d-flex flex-wrap">

                    {/* Agregar productos */}
                    <div className="col-12 col-lg-4 p-2">
                        <div className="col-12 p-0 rounded overflow-hidden sombra-1">
                            <div className="bgc-3 border-bottom p-3">
                                <div className="fs-3 fw-2 tc-1"><i className="fas fa-boxes"></i> Productos</div>
                            </div>
                            <div className="bgc-2 table-responsive col-12 p-2" style={productos}>
                                <div className="rounded">
                                    <ul className="list-group">
                                        {this.state.productos.map(pro => {
                                            return <li key={pro.idProducto} className="list-group-item list-group-item-action d-flex justify-content-between">
                                                <div className="col-8 col-sm-10 col-lg-9 p-0 pr-2">
                                                    <div className="col-12 p-0 fs-4 fw-5 tc-2 text-truncate">{pro.nombre + " " + pro.marca}</div>
                                                    <div className="d-flex">
                                                        <div className="fs-5 fw-3 tc-2 mr-1">Stock:</div>
                                                        <div className="fs-5 fw-2 tc-2">{pro.stock}</div>
                                                    </div>
                                                    <div className="fs-4 fw-2 tc-1">${pro.precio}</div>
                                                </div>
                                                <div className="col-auto p-0">
                                                    <button type="button" className="btn boton-2 border" onClick={() => this.agregarProducto(pro)}>Agregar</button>
                                                </div>
                                            </li>
                                        })}
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    {/* <div className="col-12 mb-3"></div> */}
                    
                    {/* <div className="fuente-a3 col-12 p-0">Detalle de Venta</div> */}

                    {/* Tabla detalle venta */}
                    <div className="col-12 col-lg-8 p-2">
                        <div className="col-12 p-0 rounded overflow-hidden sombra-1">
                            <div className="bgc-3 tc-c border-bottom p-3">
                                <div className="fs-3 fw-2 tc-1"><i class="far fa-list-alt"></i> Detalle Venta</div>
                            </div>
                            <div className="table-responsive col-12 mx-auto p-2 bgc-2" style={tabla}>
                                <table className="table m-0 ">
                                    <thead>
                                        <tr>
                                            <th className="fs-5 fw-2 tc-2 border-top-0">Producto</th>
                                            <th className="fs-5 fw-2 tc-2 border-top-0">Precio Unitario</th>
                                            <th className="fs-5 fw-2 tc-2 border-top-0">Cantidad</th>
                                            <th className="fs-5 fw-2 tc-2 border-top-0">Total</th>
                                            <th className="fs-5 fw-2 tc-2 border-top-0"></th>
                                        </tr>
                                    </thead>
                                    <tbody className="fs-5 tc-2">
                                        {
                                            this.state.detallesVenta.map( (proVenta, index) => {
                                                return  <tr key={index} className="">
                                                    <td>{proVenta.producto.nombre}</td>
                                                    <td>${proVenta.precioUnitario}</td>
                                                    <td><input className="form-control form-control-sm w-25 fs-5 tc-2" type="number" value={proVenta.cantidad} onChange={(e) => this.actualizarProducto(e.target.value, proVenta)}></input></td>
                                                    <td>${proVenta.total}</td>
                                                    <td><button type="button" className="btn boton-2 border btn-sm" onClick={() => this.eliminarProducto(proVenta)}>Eliminar</button></td>
                                                </tr>
                                            })
                                        }
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div className="col-12 p-2">
                        <div className="col-12 d-flex flex-wrap justify-content-between bgc-2 rounded sombra-1">
                            <div className="fs-4 tc-2 m-3">Cantidad <div className="fs-4 fw-2 tc-1">{0}</div></div>
                            <div className="fs-4 tc-2 m-3">Cantidad de productos <div className="fs-4 fw-2 tc-1">{0}</div></div>
                            <div className="fs-4 tc-2 m-3">Total<div className="fs-4 fw-2 tc-1">${this.state.venta.total ? this.state.venta.total : 0}</div></div>
                            <button type="submit" className="btn btn-lg boton-1 m-3">Realizar Venta</button>
                        </div>
                    </div>
                    

                    <div className="col-12 mb-5"></div>

                </form>
            </div>
        )
    }
}
