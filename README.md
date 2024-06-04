<h1 align="center"> 🍜 RamenGo Admin Service </h1>
<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
    </a>
  <a alt="Maven">
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white"/>
  </a>
    <a alt="Postgres">
        <img src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white" />
    </a>
    <a alt="Spring">
        <img src="	https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
    </a>
    <a alt="Spring Security">
        <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white" />
    </a>
    <a alt="AWS S3">
        <img src="https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white">
    </a>
</p>
<h2>📝 Descrição </h2>
O microserviço RamenGo Admin Service é um componente opcional, destinado a fins administrativos. Ele fornece uma interface para o gerenciamento de produtos e imagens do cardápio.
O projeto é composto por dois microserviços:

1. `RamenGo Orders Service`: Este microserviço é responsável por lidar com o processamento de pedidos e a comunicação com os clientes.

2. `RamenGo Admin Service`: Este microserviço complementar fornece funcionalidades administrativas, como o gerenciamento de produtos e imagens do cardápio.

 📮: [Collection - Postman](ramenGO-admin.postman_collection.json)

 ## API Endpoints
A API possui os seguintes endpoints:

**API PRODUCT**
```markdown
POST /manager/register - Registra novo usuário
POST /manager/login - Retorna token para gerenciar broths e proteins
POST /manager/broths - Salva novo broth
POST /manager/proteins - Salva nova protein
```

**BODY**
POST /manager/register - Registra novo usuário
```json
{
    "firstName": "",
    "lastName": "",
    "email": "",
    "password": ""
}
```

**BODY**
POST /manager/login - Retorna token para gerenciar broths e proteins
```json
{
    "email": "",
    "password": ""
}
```

**BODY**
POST /manager/broths?name=&description=&price= - Salva novo broth
```form-data
imageActive (key/file)
imageInactive (key/file)
```

**BODY**
POST /manager/proteins?name=&description=&price= - Salva nova protein
```form-data
imageActive (key/file)
imageInactive (key/file)
```

<h2>💻 Arquitetura</h2>

[Link da arquitetura](https://whimsical.com/ramengo-manager-MFvVrQP2hQkJ9pkwq2nbYT)

<h2>💻 Configuração</h2>

<table align="center">
	<td>Linguagem</td>
	<td>Java</td>
</tr>
<tr>
	<td>Framework</td>
	<td>Spring Boot</td>
</tr>
<tr>
	<td>Build Tool</td>
	<td>Maven</td>
</tr>
<tr>
	<td>Banco de Dados</td>
	<td>PostgreSQL</td>
</tr>
<tr>
	<td>Serviços externos</td>
	<td>AWS S3</td>
</tr>
<tr>
	<td>Java Version</td>
	<td>17</td>
</tr>
</table>

<hr> 
<a href = "mailto:contatodeboravicente@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
<a href="https://www.linkedin.com/in/deborasilvadlvs" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
