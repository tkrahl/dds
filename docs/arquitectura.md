```mermaid
flowchart LR

Cliente([Cliente]) --> APIGateway[API Gateway]

subgraph Solucion
    ServicioIncentivos[Servicio de incentivos]
    ServicioDonadores[Servicio de Donadores y Entidades]
    ServicioIncentivos --> ServicioDonadores
end

APIGateway --> ServicioIncentivos
```
