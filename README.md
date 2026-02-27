# CPS3250_Group5 
Developed by `Huang Yawen`<br>
About the `DeadLock Detection and Prevention`<br>

<img src="https://raw.github.com/Roselia-penguin/img-storage/master/cat1.jpg" width="100">

**DeadLock Detection and Prevention** - 一个用于演示和模拟操作系统中死锁检测与预防算法的Java项目。本项目是CPS3250课程的小组作业，由Huang Yawen开发。

## 📖 项目简介

本项目旨在通过Java编程语言，模拟计算机系统中进程资源请求的场景，并实现经典的**死锁检测**与**死锁预防**算法。它可以帮助学习者直观地理解死锁产生的四个必要条件（互斥、持有并等待、不可剥夺、循环等待），以及如何通过打破这些条件或使用银行家算法等策略来避免系统进入死锁状态。
<img width="750" height="448" alt="image" src="https://github.com/user-attachments/assets/6efcf23b-13c4-4433-9ea1-f1163643542c" />

Normal Situation:
<img width="601" height="607" alt="image" src="https://github.com/user-attachments/assets/6298abae-9b96-4751-aa29-24e882c5aa20" />

DeadLock Situation:
<img width="524" height="529" alt="image" src="https://github.com/user-attachments/assets/75adba3f-8a67-4de7-9258-617d0bd495ec" />

Banker's Algorithm GUI：
<img width="674" height="415" alt="image" src="https://github.com/user-attachments/assets/3ba15709-b059-4bf0-9584-aeebcfd57f23" />

When input is correct:

Safely allocated:
<img width="655" height="401" alt="image" src="https://github.com/user-attachments/assets/f884285f-2e4f-41d7-9dfc-2fdea74526d4" />

UnSafe:
<img width="667" height="409" alt="image" src="https://github.com/user-attachments/assets/3d69f8cd-02fc-4b39-9f41-33c9eeda48b0" />


## ✨ 功能特性

*   **死锁检测**：实现算法，定期检查系统资源分配图是否存在循环等待，从而判定死锁是否发生。
*   **死锁预防**：通过模拟打破死锁必要条件之一的策略（例如，实现资源有序分配法），展示如何从设计上预防死锁。
*   **资源分配模拟**：允许用户（或通过预设场景）创建多个进程和多种资源，并模拟进程的请求、获得和释放资源行为。
*   **状态可视化**：通过控制台输出或简单的图形界面，清晰展示当前资源分配图和进程状态。
*   **银行家算法**：可选地实现银行家算法，进行安全性序列检查，以决定是否批准资源请求。

## 🛠️ 技术栈

*   **编程语言**：Java 100%
*   **核心概念**：多线程编程、并发控制、操作系统死锁算法
*   **开发环境**：IntelliJ IDEA (基于项目中的 `.idea` 目录)

## 🚀 快速开始

### 前提条件

确保您的系统已安装 **Java Development Kit (JDK) 8 或更高版本**。

### 运行项目

您可以通过以下两种方式运行此项目：

#### 方式一：通过IDE（推荐）

1.  **克隆仓库**
    ```bash
    git clone https://github.com/Roselia-penguin/CPS3250_DeadLock-Detection-and-Prevention.git
    ```
2.  **打开项目**
    *   打开 IntelliJ IDEA 或其他Java IDE。
    *   选择“打开”或“导入项目”，然后导航到您克隆的仓库目录。
3.  **运行主类**
    *   在IDE中，找到包含 `main` 方法的入口类（通常位于 `src/` 目录下）。
    *   右键点击该文件，选择“运行”以启动模拟程序。

#### 方式二：通过命令行编译运行

1.  **克隆仓库**（同上）
2.  **进入src目录**
    ```bash
    cd CPS3250_DeadLock-Detection-and-Prevention/src
    ```
3.  **编译Java文件** (假设主类名为 `Main.java`，请根据实际情况调整)
    ```bash
    javac Main.java
    ```
4.  **运行程序**
    ```bash
    java Main
    ```

## 💡 核心算法示例

### 死锁检测算法 (简化描述)
程序通过维护一个**资源分配图**来检测循环等待。算法步骤大致如下：
1.  为每个进程和资源创建节点。
2.  跟踪每个资源当前被哪个进程持有，以及每个进程正在等待哪个资源。
3.  定期或在每次资源请求后，执行图的环路检测。
4.  如果发现环路，则判定为死锁，并输出涉及死锁的进程ID。
*   参考了操作系统教材中关于死锁的经典算法。


## 📁 项目结构

