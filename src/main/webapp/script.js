

function totalAPagar (cantTickets, servicio){
    const valorServicio = 1500;
    let total= cantTickets * valorServicio;

    if (servicio=="venus") {
       total = total - (total * 80 / 100)
    } else if (servicio=="drenaje") {
            total = total - (total * 50 / 100)
     } else {
            total = total - (total * 15 / 100)
        }
     return total
    }
   
   
let boton1 = document.getElementById("liveAlertBtnResumen")

let formulario = document.getElementById("formServicios")
formulario.addEventListener("submit", (e)=>{
    e.preventDefault();
})

boton1.addEventListener("click", ()=>{
    let cantidad = document.getElementById("CantidadVouchers").value 
    let servicio = document.getElementById("Servicios").value

    let valor = totalAPagar (cantidad, servicio)

    let mensaje = document.getElementById("liveAlertTotalAPagar")
    mensaje.textContent = "Total a Pagar: $" + valor
}
)

let boton2 = document.getElementById("liveAlertBorrar")

   boton2.addEventListener("click", ()=>{
    let mensaje = document.getElementById("liveAlertTotalAPagar")
    mensaje.textContent = "Total a Pagar: $" 
   })
