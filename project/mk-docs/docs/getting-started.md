## Deploying FilmFox

This section will get you up and running with deploying the FilmFox
application on your local machine. One of the main focuses of FilmFox is to create a simple and down-to-the-point deployment
routine. It shouldn't take hours and hours of playing around with config files,
dependency servers, incompatibilities, etc. to get you to a running state. So let's do this as quick as possible. Read on!

---
### Running Dependencies with Vagrant
First thing you'll need is Vagrant (and VirtualBox). Vagrant helps us setup a portable environment so that we can
set up all the dependency servers we require using a simple script located in the root directory
of the repository, called 'Vagrantfile'. For more information about Vagrant, please visit [Vagrant](https://www.vagrantup.com/).

FilmFox was developed using VirtualBox as the underlying Vagrant provider, although you can use VMWare as well, however that has not been formally
tested (just yet!)

Tested under:
> VirtualBox - Version 5.0.6 r103037
<br/>Vagrant - Version 1.8.1

#### Step-by-step
1. Download and install VirtualBox v5.0.6 or later @ [VirtualBox Downloads](https://www.virtualbox.org/wiki/Downloads)
2. Download and install Vagrant @ [Vagrant Downloads](https://www.vagrantup.com/downloads.html)
3. Navigate to the root directory of the FilmFox repository and run the following command in Terminal or Command Line:
```bash
> vagrant up
```
4. After vagrant has finished downloading/provisioning the servers needed for the application to run, you can proceed to the next section.

---
### Running the application
Running the application once Vagrant is up and running is simple. Here's how to do it:

> If you're running the application for the first time, you should load in some sample data into the environment.
To do this, we grab the CQL script from src/main/resources named BaseCassandraData.cql and execute the full
content on a Cassandra CQL command line (using cqlsh tool). To get the full configuration for Cassandra, observe src/main/resources/application.properties file.
(Automation of execution of this script will be coming in future release.)

#### Step-by-step
1. In the Terminal or Command Line, to start up the app, just run:

On Linux or OSX
```bash
> ./activator run
```
On Windows
```bash
> activator.bat run
```

2. Navigate to your browser and open `http://localhost:8080`

That's all there is to it. My aim is to make it stay this way, as simple and clean as possible.

### Customizing your build
#### Setting a custom port
FilmFox app lets you choose which port to bind the application on. By including a simple command line flag, you can
perform this operation:

On Linux or OSX
```bash
> ./activator -Dserver.port=9000 run
```
On Windows
```bash
> activator.bat -Dserver.port=9000 run
```

In this example we set the port to be 9000, but you are free to set a port of your own choosing (make sure to pick
an open port and above the 1024 range for fear of potential collisions).