-----------------Intersemestral_ProyectoFinal------------------------------

..................Descripción del Proyecto....................................

Este proyecto de Java construye una interfaz gráfica completa utilizando
Swing, que simula un sistema de ingreso y control clínico veterinario. 
Permite la navegación entre distintas vistas, integrando múltiples 
componentes visuales, estructuras jerárquicas, formularios interactivos 
y almacenamiento temporal de datos para el manejo de propietarios, 
mascotas, consultas, vacunas, citas y veterinarios 
Adicionandole Herencia.
implementacion de todo lo del intersemestral

..................Estructura o Paquetes......................................

- modelo: contiene las clases principales del dominio del sistema:

  * Propietario: contiene datos del propietario y una lista de mascotas.
  * Mascota: contiene datos de la mascota (nombre, especie, peso, etc.) y una lista de consultas.
  * Consulta: contiene código, fecha, diagnóstico, tratamiento y una referencia a una mascota.
  * Cita: permite agendar fecha y hora para una mascota con un veterinario.
  * Vacuna: permite registrar el tipo de vacuna administrada a una mascota.
  * Veterinario: contiene nombre, especialidad y disponibilidad.

  * Persona_SuperClase: clase padre de propietario y veterinario.
  * EventoClinico_SuperClase: clase padre de consulta, cita, vacuna.

- ventana (o ejecución): contiene todas las interfaces gráficas:

  * Ventana1: ventana inicial del sistema que da la bienvenida y dirige a los módulos principales.
  * VentanaMascota: permite registrar, editar, eliminar, buscar y mostrar mascotas.
  * VentanaConsulta: permite registrar, editar, eliminar, buscar y visualizar consultas.
  * VentanaVacuna: administra el registro de vacunas aplicadas a las mascotas.
  * VentanaAgendamientoDeCita: permite agendar, buscar, editar y eliminar citas médicas.
  * VentanaVeterinario: permite registrar veterinarios disponibles.
  * VentanaServicio: muestra el menú principal de servicios y una barra de carga para mejorar la interacción.

  * Ventana Historial: muestra la descripcion de todos los registro asociados a una mascota.

..................Librerias Utilizadas......................................

- `Scanner`: para entrada de datos en consola durante pruebas simples.
- `ArrayList`: para el almacenamiento temporal de entidades como listas de mascotas, consultas, etc.
- `JOptionPane`: para mostrar mensajes interactivos al usuario.
- `Swing`: para la construcción de interfaces gráficas (JFrame, JPanel, JComboBox, JTable, etc.).
- `javax.swing.table.DefaultTableModel`: para manejar los datos de las tablas.

..................Objetivos................................................

1. Comprender el proceso de análisis de requisitos y levantamiento de entidades.
2. Modelar entidades y relaciones usando clases Java con orientación a objetos.
3. Aplicar principios fundamentales como encapsulamiento, asociación y modularización.
4. Fortalecer el uso de estructuras dinámicas como listas y combos.
5. Desarrollar una interfaz gráfica amigable para el usuario.
6. Simular un sistema real con interacciones de usuario, validaciones y flujo logico.

..................Características Principales...............................

- Registro completo de propietarios, mascotas, vacunas, consultas y citas.
- Validación de datos numéricos (como peso y edad) usando excepciones `try-catch`.
- Uso de combos (`JComboBox`) para selección de veterinarios disponibles.
- Separación en paquetes (`modelo` y `ventana`) para una estructura organizada.
- CRUD completo en cada módulo (Crear, Leer, Editar, Eliminar).
- Simulación de relaciones entre clases como 1:N (Propietario → Mascotas) y N:1 (Consulta → Veterinario).
- Navegación entre ventanas y actualización en tiempo real de tablas.
- Interfaz amigable con uso de pestañas, botones de navegación y confirmaciones.


..........................Autora........................................

Autora: Samantha Echeverri Ramirez  
