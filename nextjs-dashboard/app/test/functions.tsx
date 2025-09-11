// 手撕题
// bind call apply

// instanceof 和 typeof
// 当涉及对对象具体类型的判断时，需要使用instanceof。
const a = [1, 2, 3];
console.log(a instanceof Array); // true
console.log(a instanceof Object); // true
console.log(typeof a); // object

// 深拷贝
const myObject = {
    name: 'Alice',
    age: 30,
    address: {
        city: 'New York',
        zip: '10001'
    },
    hobbies: ['reading', 'traveling']
};

// JSON 方法, 只能处理简单对象，不能处理函数、undefined、循环引用等
function myDeepCopy(obj: any) {
    return JSON.parse(JSON.stringify(obj));
}
const copiedObj = myDeepCopy(myObject);

// 递归方法
function myDeepCopy2(obj: any) {
    if (obj === null || typeof obj !== 'object') {
        return obj; // 处理 null 和基本类型
    }
    const newObj: any = Array.isArray(obj) ? [] : {};
    for (const key in obj) {
        if (obj.hasOwnProperty(key)) {
            newObj[key] = myDeepCopy2(obj[key]); // 递归拷贝
        }
    }
    return newObj;
}
const copiedObject = myDeepCopy2(myObject);
// 节流 防抖 
// 防抖的目的是为了在事件触发后的一段时间内不再触发函数，适用于输入框实时搜索等场景。
// 节流的目的是为了限制函数的执行频率，适用于窗口 resize、滚动等高频触发的场景。
// promise
// async await
// event loop
// 作用域
// 闭包
// 原型链
// 垃圾回收机制
// 箭头函数与普通函数的区别
// 变量提升
// 事件委托
// 跨域解决方案
// HTTP 状态码
// RESTful API 设计原则
// 前端性能优化方法
// 浏览器缓存机制
// HTTPS 工作原理
// 前端安全问题及防范措施
// React 生命周期
// React 状态管理方案比较（Context API, Redux, MobX 等）
// React 性能优化方法
// React Hooks 原理及常用 Hooks 使用场景