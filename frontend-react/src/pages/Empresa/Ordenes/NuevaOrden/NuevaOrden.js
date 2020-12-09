import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class NuevaOrden extends Component {

    state = {
        orden: {},
        detallesOrden: [],
        productos: []
    }

    componentDidMount(){
        this.obtenerProductos();
    }

    /* Eventos */
    onSubmit = (e) => {
        e.preventDefault();
        this.guardarOrden();
    }

    /* Funciones */
    async obtenerProductos(){
        let fetchResult = await fetch('http://localhost:8081/api/productos');
        let result = await fetchResult.json();
        
        this.setState({
            productos: result
        })
    }
    
    async guardarOrden(){
        try {
            
            let orden = {};
            let empleado = {};
            let proveedor = {};
            let ordenDetalle = {};

            empleado.idEmpleado = 1;

            proveedor.idProveedor = 1;

            orden.total = this.state.orden.total;
            orden.estado = 'Creada';
            orden.empleado = empleado;
            orden.proveedor = proveedor;

            ordenDetalle.orden = orden;
            ordenDetalle.detallesOrden = this.state.detallesOrden;
            
            let fetchResult = await fetch('http://localhost:8081/api/ordenDetalle', {
                method: 'POST',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(ordenDetalle)
            })

            let result = await fetchResult.json();

            console.log(result)
            console.log(fetchResult.status)
            
        } catch (error) {
            console.log("Error al guardar orden:", error)
        }
    }

    agregarProducto = (pro) => {
        
        let lista = this.state.detallesOrden;

        let detalleOrden = {};

        detalleOrden.cantidad = 1;
        detalleOrden.precioUnitario = pro.precio;
        detalleOrden.total = pro.precio * detalleOrden.cantidad;
        detalleOrden.producto = pro;

        lista.push(detalleOrden)

        this.setState({
            detallesOrden: lista
        })

        this.calcular();
    }

    actualizarProducto = (value, pro) => {

        let lista = this.state.detallesOrden;

        lista.forEach(p => {
            if(p === pro){
                p.cantidad = value;
            }
        });
        
        this.setState({
            detallesOrden: lista
        })

        this.calcular();
    }

    eliminarProducto = (pro) => {

        let lista = this.state.detallesOrden;

        lista.forEach( (p,i) => {
            
            if(p === pro){
                lista.splice(i,1)
            }
        });

        this.setState({
            detallesOrden: lista
        })
    }

    calcular(){

        let detallesOrden = this.state.detallesOrden;
        let ord = {};
        let total = 0;

        detallesOrden.forEach( detOrd => {
            
            detOrd.total = detOrd.cantidad * detOrd.precioUnitario
            
            total += detOrd.total
        });
        
        ord.total = total;

        this.setState({
            orden: ord
        })
    }

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

                {/* Opciones */}
                <div className="col-12 p-2 d-flex justify-content-between align-items-start">
                    <div>
                        <Link to="/empresa/ordenes">
                            <button type="button" className="btn boton-1 sombra-1 mr-2"><i class="fas fa-th-list"></i> Lista de pedidos</button>
                        </Link>
                        <button type="button" className="btn boton-2 sombra-1" onClick={this.clickBtnActualizar}><i className="fas fa-sync-alt"></i> Actualizar lista</button>
                    </div>
                </div>

                {/* Formulario */}
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

                    {/* Tabla detalle venta */}
                    <div className="col-12 col-lg-8 p-2">
                        <div className="col-12 p-0 rounded overflow-hidden sombra-1">
                            <div className="bgc-3 tc-c border-bottom p-3">
                                <div className="fs-3 fw-2 tc-1"><i className="far fa-list-alt"></i> Detalle Orden</div>
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
                                            this.state.detallesOrden.map( (proOrden, index) => {
                                                return  <tr key={index} className="">
                                                    <td>{proOrden.producto.nombre}</td>
                                                    <td>${proOrden.precioUnitario}</td>
                                                    <td><input className="form-control form-control-sm w-25 fs-5 tc-2" type="number" value={proOrden.cantidad} onChange={(e) => this.actualizarProducto(e.target.value, proOrden)}></input></td>
                                                    <td>${proOrden.total}</td>
                                                    <td><button type="button" className="btn boton-2 border btn-sm" onClick={() => this.eliminarProducto(proOrden)}>Eliminar</button></td>
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
                            <div className="fs-4 tc-2 m-3">Total<div className="fs-4 fw-2 tc-1">${this.state.orden.total ? this.state.orden.total : 0}</div></div>
                            <button type="submit" className="btn btn-lg boton-1 m-3">Realizar Venta</button>
                        </div>
                    </div>


                    <div className="col-12 mb-5"></div>

                </form>
            </div>
        )
    }
}
