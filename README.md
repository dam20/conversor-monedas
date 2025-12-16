# Conversor de Monedas (Java)

## 📌 Descripción

Aplicación de consola desarrollada en **Java 21** con **Maven**, orientada a objetos, que permite convertir montos entre distintas monedas utilizando tasas de cambio obtenidas desde una API externa.

El proyecto fue diseñado aplicando principios de **POO**, **separación de responsabilidades** y **testeo unitario**, con el objetivo de servir tanto como ejercicio práctico como base para una aplicación más compleja.

---

## 🧱 Arquitectura del proyecto

La aplicación sigue una estructura por capas clara:

```
com.conversor
│
├── app        → Punto de entrada (UI de consola)
├── api        → Acceso a la API externa
├── modelo     → Modelos / DTOs
└── servicio   → Lógica de negocio
```

### Responsabilidades

* **app**: interacción con el usuario
* **servicio**: lógica de conversión y validaciones
* **api**: comunicación HTTP y parseo JSON
* **modelo**: estructuras de datos

---

## 🔧 Tecnologías utilizadas

* Java 21
* Maven 3.9+
* JUnit 5
* Gson
* ExchangeRate API

---

## 🔐 Configuración de la API Key

Antes de ejecutar la aplicación, definir la variable de entorno:

EXCHANGE_API_KEY=tu_api_key

La clave no se incluye en el repositorio por razones de seguridad.

---

## 🚀 Ejecución del proyecto

### Compilar

```bash
mvn clean compile
```

### Ejecutar la aplicación

```bash
mvn exec:java -Dexec.mainClass="com.conversor.app.AplicacionConsola"
```

### Ejecutar tests

```bash
mvn test
```

---

## 🧪 Testing

Se implementaron **pruebas unitarias con JUnit 5**, utilizando un `FakeApiClient` para aislar la lógica de negocio del acceso real a la API.

Esto permite:

* Tests rápidos
* Tests deterministas
* Cumplir el principio de inversión de dependencias

---

## ⚠️ Manejo de errores

La aplicación define una excepción personalizada:

* `ConversionException`: utilizada para encapsular errores de negocio o fallos en la obtención de tasas.

---

## 📈 Posibles mejoras futuras

* Cache de tasas en memoria
* Interfaz gráfica
* Persistencia local
* Soporte para múltiples proveedores de tasas
* Internacionalización

---

## 👤 Autor

Desarrollado por **David Moyano**

* GitHub: [https://github.com/dam20](https://github.com/dam20)
* LinkedIn: [https://www.linkedin.com/in/david-moyano-5194b5147/](https://www.linkedin.com/in/david-moyano-5194b5147/)

---

## 📄 Licencia

Proyecto de uso educativo y demostrativo.
