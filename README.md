# 🚀 NavIC Operations Meeting Management Software (NavOM) 

This is a Spring Boot based web application that manages the operational meetings, each meeting attendance. The members can report issues on this website regarding the systems, servers, etc. This website is authenticated and authorized with the Spring Security.
---

## 📌 Features
- CRUD Operations
- User Authentication & Authorization
- Role-Based Access Control
- REST APIs
- Database Integration (PostgreSQL)

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Security:** Spring Security
- **Database:** PostgreSQL
- **ORM:** JPA / Hibernate
- **Build Tool:** Maven
---

## 📂 Project Structure

ndorc/
│── src/main/java/com/example/project
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── entity/
│ └── config/
│
│── src/main/resources/
│ ├── application.properties
│ └── templates/
│
│── pom.xml
│── README.md


---

## ⚙️ Installation & Setup

### 1️⃣ Installation

#!/bin/bash

set -e

echo "Detecting Operating System..."

OS_TYPE=""
DISTRO=""

# Detect Windows (Git Bash / MINGW / MSYS)
if [[ "$OSTYPE" == "msys" || "$OSTYPE" == "win32" || "$OSTYPE" == "cygwin" ]]; then
    OS_TYPE="windows"
fi

# Detect Linux
if [[ "$OSTYPE" == "linux-gnu"* ]]; then
    if [ -f /etc/os-release ]; then
        . /etc/os-release
        DISTRO=$ID
    fi

    case "$DISTRO" in
        ubuntu|debian)
            OS_TYPE="ubuntu"
            ;;
        rhel|centos|fedora|rocky|almalinux)
            OS_TYPE="redhat"
            ;;
        *)
            echo "Unsupported Linux distribution: $DISTRO"
            exit 1
            ;;
    esac
fi

echo "Detected OS: $OS_TYPE"

install_ubuntu() {
    echo "Updating package list..."
    sudo apt update

    echo "Installing OpenJDK 17..."
    sudo apt install -y openjdk-17-jdk

    echo "Installing PostgreSQL..."
    sudo apt install -y postgresql postgresql-contrib

    echo "Installation completed on Ubuntu."
}

install_redhat() {
    echo "Updating packages..."
    sudo dnf update -y || sudo yum update -y

    echo "Installing OpenJDK 17..."
    sudo dnf install -y java-17-openjdk java-17-openjdk-devel || \
    sudo yum install -y java-17-openjdk java-17-openjdk-devel

    echo "Installing PostgreSQL..."
    sudo dnf install -y postgresql-server postgresql-contrib || \
    sudo yum install -y postgresql-server postgresql-contrib

    echo "Initializing PostgreSQL database..."
    sudo postgresql-setup --initdb || true

    sudo systemctl enable postgresql
    sudo systemctl start postgresql

    echo "Installation completed on RedHat-based system."
}

install_windows() {
    echo "Windows detected."

    echo "Please install via package manager (recommended: winget or chocolatey)"

    echo "Installing OpenJDK 17 via winget..."
    winget install -e --id EclipseAdoptium.Temurin.17.JDK

    echo "Installing PostgreSQL via winget..."
    winget install -e --id PostgreSQL.PostgreSQL

    echo "Installation commands executed for Windows."
}

case "$OS_TYPE" in
    ubuntu)
        install_ubuntu
        ;;
    redhat)
        install_redhat
        ;;
    windows)
        install_windows
        ;;
    *)
        echo "Unsupported OS"
        exit 1
        ;;
esac

echo "Verifying installations..."
java -version
psql --version

echo "Setup completed successfully!"

## 🚀 How to use
     chmod +x setup.sh
     ./setup.sh	

### 2️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/project-name.git
cd project-name


### 3️⃣ Configure Database

	spring.datasource.url=jdbc:postgresql://localhost:5432/db_name
	spring.datasource.username=your_username
	spring.datasource.password=your_password

### 4️⃣ Build the project

	mvn clean install 
	Run this command the project directory 

### 5️⃣ Run the application
	
	mvn spring-boot:run


