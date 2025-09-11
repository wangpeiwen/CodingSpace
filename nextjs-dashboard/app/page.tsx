"use client";
import { Button } from "./ui/button";

export default function Page() {
  for(var i=0;i<=5;i++){
    setTimeout(()=>{
      console.log(i);
    },1000)
  };

  for(let i=0;i<=5;i++){
    setTimeout(()=>{
      console.log(i);
    },1000)
  };
  // 节流处理按钮点击事件
  const handleClick = () => {
    console.log("Button clicked!");
  };
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-24">
      <h1 className="text-3xl font-bold underline">Hello, Next.js!</h1>
      <Button className="bg-blue-500 text-white py-2 px-4 rounded" onClick={handleClick}>Click Me</Button>
    </main>
  );
}
