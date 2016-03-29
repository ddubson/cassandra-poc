## Deploying FilmFox

This section will get you up and running with deploying the FilmFox
application on your local machine. One of the main focuses of FilmFox is to create a simple and down-to-the-point deployment
routine. It shouldn't take hours and hours of playing around with config files,
dependency servers, incompatibilities, etc. to get you to a running state. So let's do this as quick as possible. Read on!

---
### Running Dependencies with Vagrant
First thing you'll need is Vagrant (and VirtualBox). Vagrant helps us setup a portable environment so that we can
set up all the dependency servers we require using a simple script located in the root directory
of the repository, called 'Vagrantfile'. For more information about Vagrant, please visit https://www.vagrantup.com/.

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

TBD