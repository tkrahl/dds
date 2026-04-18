flowchart LR
    n1["Cliente"] --> n2["API Gateway"]
    n6["Servicio de incentivos"] --> n7["Servicio de Donadores y Entidades"]
    n2 --> n6
    n5["<br>"]
    n8["Solucion"]

    n1@{ shape: rounded}
    n2@{ shape: rect}
    n7@{ shape: rect}
    n5@{ shape: rounded}
    n8@{ shape: text}
    style n5 fill:transparent
