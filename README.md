## Java Dynamic Proxy Sample


---

本例是一个简单的 `Java` 动态代理的例子。以 `ArrayList` 为样例，进行了封装，其内部实现和 `ArrayList` 中完全相同的功能，增加了计算 `ArrayList` 每个方法运行的时间。
### Java Dynamic Proxy
Dynamic Proxy是这样一种`class`：它是在运行时生成的`class`，在生成它时你必须提供一组`interface`给它，然后该`class`就宣称它实现了这些 `interface`。你当然可以把该class的实例当作这些`interface`中的任何一个来用。当然，这个Dynamic Proxy其实就是一个Proxy，它不会替你作实质性的工作，在生成它的实例时你必须提供一个`handler`，由它接管实际的工作.
### 代码简述

`ArrayListHandler`类实现了 `InvocationHandler`接口，实现接口中定义的`invoke`方法。`invoke`方法的参数说明：
>* `Object proxy`：指被代理的对象
>* `Method method`：要调用的方法,也就是被代理的对象真正执行的方法 
>* `Object[] args`：方法调用时所需要的参数 

`ArrayListHandler`类中还定义了一个方法`bind`,此方法是通过`Proxy`类生成一个代理类。

#### `Proxy` 类

*Proxy provides static methods for creating dynamic proxy classes and
instances, and it is also the superclass of all dynamic proxy classes
created by those methods.*

`Proxy`这个类的作用就是用来动态创建一个代理对象的类，它提供了许多的方法，但是我们用的最多的就是 `newProxyInstance` 这个方法：

`public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)  throws IllegalArgumentException`

参数说明：
>* `loader`: 一个`ClassLoader`对象，定义了由哪个`ClassLoader`对象来对生成的代理对象进行加载
>* `interfaces`: 一个`Interface`对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
>* `h`: 一个`InvocationHandler`对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个`InvocationHandler`对象上

### 总结
一个典型的动态代理创建对象过程可分为以下几个步骤：
>* 通过实现`InvocationHandler`接口创建自己的调用处理器 `IvocationHandler handler = new InvocationHandlerImpl(...)`;
>* 通过为`Proxy`类指定`ClassLoader`对象和一组`interface`创建动态代理类






