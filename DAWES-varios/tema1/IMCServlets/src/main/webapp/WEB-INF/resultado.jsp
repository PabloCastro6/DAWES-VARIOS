<html>
<head>
    <title>Resultado IMC</title>
</head>
<body>
    <h2>Resultado del Índice de Masa Corporal (IMC)</h2>
    <p>La persona <%= request.getAttribute("nombre") %> tiene un IMC de <%= request.getAttribute("imc") %>.</p>
    <a href="index.jsp">Calcular otro IMC</a>
</body>
</html>
