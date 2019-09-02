package com.ysccc.startkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewDebug
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import java.lang.Exception
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    var i:Int=0
    val login:String="login:{\"username\":\"18328359157\",\"password\":\"915544\"}"
    var array_string:Array<String> = arrayOf("How","Are","You")//声明字符串的数组
    var array_int:IntArray= intArrayOf(1,2,3)  //声明int数组类型
    var array_long:LongArray= longArrayOf(1,2,3) //声明long型数组变量
    var array_float:FloatArray= floatArrayOf(1.0f,2.0f,3.0f)  //声明单浮点型数组变量
    var array_double:DoubleArray= doubleArrayOf(1.0,2.0,3.0)  //声明双浮点型数组变量
    var array_boolean:BooleanArray= booleanArrayOf(true,false,true) //声明布尔类型的数组变量
    var array_char:CharArray= charArrayOf('a','b','c') //声明字符类型的数组变量

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_hello.text = "你好啊"

        button.setOnClickListener {
         /*   button.text = "你点了一下下";
            tv_hello.text = "很高兴认识你";
            toast("你点了一下下")*/
            /**
             * 访问字符串的某个位置
             */
       /*    var start:Int=19
            var end:Int=30
            //截取一段数字
               button.text=login.substring(start,end)
            //截取一个字符，转字符串
            button.text=login[start].toString()
            button.text=login.get(start).toString()*/
            /***
             * 字符串拼接
             */
//            button.text="字符串值为$login"//这种方式会使字符串小写字母变成大写字母
//            button.text="字符串的长度${login.length}"//这种拼接会把大括号的先运算出来，再拼接
//            button.text="美元金额为${'$'}${login.length}"//这种拼接就把$符号拼接出来了，不会被混淆
//            button.text="美元金额为\$${login.length}"//和上面的效果一样，只是有个\，把$不会被编译，直接拼接
            /***
             * set集合，for-in循环,迭代器,for-each循环
             */
           /* val phone:Set<String> = setOf("iphone8","mate10","小米6","oppo","vivo")
            var phone_name=""*/
           /* for (item in phone){
                phone_name="${phone_name}名称：${item}\n"
            }*/
            //迭代器
            /*val iterator=phone.iterator()
                while (iterator.hasNext()){
                    val item=iterator.next();
                    phone_name="${phone_name}名称:${item}\n";
                }*/
            //for-each循环，在编码时，采用的是匿名函数的形式，内部使用it代表每个元素
         /*  phone.forEach { phone_name= "${phone_name}名称:${it}\n" }*/



            /***
             * 队列List，MutableList
             */

          val phone:List<String> = listOf("iphone8","mate10","小米6","oppo","vivo")
         var phone_name=""
            //按元素下标循环遍历：indices是队列的下标数组，如果队列的大小为10，下标数组取值为0~9
            for (i in phone.indices){
                val item=phone[i]
                phone_name="${phone_name}名称：${item}\n"
            }
//            button.text="手机畅销榜包含以下${phone.size}种手机：\n$phone_name"
            button.setGravity(Gravity.LEFT)

             //MutableList提供了sort系列方法，给队列中的元素重新排序：升序sortBy 降序sortByDescending
           var sortAsc=true
            if (sortAsc){
                //sortBy表示升序，后面跟得是排序的条件
                phone.sortedBy { it.length }
            }else{
                //sortByDescending表示降序，后面跟的是排序的条件
                phone.sortedByDescending { it.length }
            }
            for (item in phone){
                phone_name="${phone_name}名称：${item}\n"
            }
            button.text="手机畅销榜已按照${if (sortAsc)"升序" else "降序"}重新排列：\n$phone_name"
            sortAsc=!sortAsc
            val phoneMap:Map<String ,String> = mapOf("苹果" to "iphone8","华为" to "mate10","小米" to "小米6","OPPO" to "oppo")
            var phoneMutMap:MutableMap<String,String> = mutableMapOf(Pair("苹果","iphone8"),Pair("华为","mate10"),
                Pair("小米","小米6"),Pair("OPPO","oppo"))
            for (item in phoneMap){
                phone_name="${phone_name}厂家：${item.key},名称：${item.value}\n"
            }
            button.text="手机畅销榜包含以下${phoneMap.size}种手机：\n$phone_name"
        }
        long_click_button.setOnLongClickListener {
            long_click_button.text = "你长按了一会儿";
            longToast("你长按了一会儿");true
        }
        val origin:Float=65.0f
        button_string.text=origin.toString()
        var int:Int=0
        var is_old:Boolean =true
        var countType:Number
        button_int.text="凉风有信,秋月无边，打两字"
        button_int.setOnClickListener {
//            int=origin.toInt();button_int.text=int.toString()
            /***
             * 简单分支：if -else
             */
          /*  if (is_old){
                button_int.text="凉风有信的谜底是讽"
            }else{
                button_int.text="秋月无边的谜底是二"
            }
            is_old=!is_old*/
            //还可以这样写**********************************相当于三元运算
           /* button_int.text = if (is_old == true) "凉风有信的谜底是讽" else "秋月无边的谜底是二"
              is_old=!is_old*/
            /***
             * 多分支：when ->   if语句可以没有else，但是when语句必须带上else
             *
             * switch/case语句与when/else语句的区别
             * 1、关键字switch被when取代
             * 2、判断语句“case常量值”被新语句“常量值->”取代
             * 3、每个分支后面的break语句被取消了
             * 4、关键字default被else取代
             * 5、case后面只能跟常量，但是“常量值->”这里的常量可以引入变量,也可以是一串常量
             */

           /* when (int){
                0 -> button_int.text="凉风有信的谜底是讽"
                1-> button_int .text="秋月无边的谜底是二"
                else -> button_int.text="这是一首好诗"
            }*/
            //也可以写成
            val even:Int=1
      /*      button_int.text = when (int){
                int ->"凉风有信的谜底是讽"
               even->"秋月无边的谜底是二"
                else -> "这是一首好诗"
            }*/
           /* button_int.text = when (int){
                0,2,8 ->"凉风有信的谜底是讽"
                in 9..11->"秋月无边的谜底是二"
                !in 2..8 ->"你来猜"
                else -> "这是一首好诗"
            }
            int=(int+1)%11*/
            /***
             * 类型判断：Java关键字：instanceof 替换成is
             */
           int=(int+1)%3
            countType=when(int){
                0 -> int.toLong()
                1 ->int.toDouble()
                else ->int.toFloat()

            }
           button_int.text=when(countType){
               is Long -> "此恨绵绵无绝期"
               is Double ->"树上鸟儿成双对"
               else ->"门泊东吴万里船"
           }

        }
        /***
         * 遍历循环 for（item in 数组） for（i in 数组.indices）indices表示数组变量的下标数组
         * while ,do -while 和Java的用法差不多
         * Kotlin仍然保留了for和while循环，主要区别是kotlin取消了“for（初始；条件；增减）”这个规则，同时新增了对跳出多重循环的支持
         * （通过“break@标记位”实现）
         */
        var long:Long
        val array:Array<String> = arrayOf("朝辞白帝彩云间", "千里江陵一日还","两岸猿声啼不住" ,"轻舟已过万重山")
        val array2:Array<String?> = arrayOf("朝辞白帝彩云间", "","千里江陵一日还","两岸猿声啼不住" ,"轻舟已过万重山",null)
        var pos:Int =-1
        button_long.setOnClickListener {
           var poem:String =""
            //indices表示数组变量的下标数组
         /*   for (i in array.indices){
                if (i%2==0){
                    poem="$poem${array[i]}，\n"
                }else{
                    poem="$poem${array[i]}。\n"
                }
            }
            button_long.text=poem*/
          /*  while (i<array.size){
                if (i%2==0){
                    poem="$poem${array[i]}，\n"
                }else{
                    poem="$poem${array[i]}。\n"
                }
                i++
            }
            poem="${poem}该诗歌一共有${i}句"
            button_long.text=poem*/
         /*   do {
                if (i%2==0){
                    poem="$poem${array[i]}，\n"
                }else{
                    poem="$poem${array[i]}。\n"
                }
                i++
            }while (i<array.size)
            poem="${poem}该诗歌一共有${i}句"
            button_long.text=poem*/
          /*  while (pos<array2.size){
                pos++
                if (array2[pos].isNullOrBlank())
                    continue

                if (i%2==0){
                    poem="$poem${array[i]}，\n"
                }else{
                    poem="$poem${array[i]}。\n"
                }
                i++
                if (i==4)
                    break
        }
            button_long.text=poem*/
            var is_found:Boolean =false
            outside@ while(i<array.size){
                var item = array[i]
                var j : Int = 0
                while (j < item.length){
                    if (item[j] == '一'){
                        is_found = true
                        break@outside
                    }
                    j++
                }
                if (is_found)
                    break
                Log.d("msg","跳出两重循环")
                i++
        }
            button_long.text=if (is_found) "找到‘一’了" else "没有找到‘一’字"
        }
        /***
         * 空安全：
         * isNullOrEmpty:为空指针或者字符长度为0时返回true，非空字符串与可空串均可调用
         * isNullOrBlank:为空指针、字符串为0或者全为空格时返回true，非空字符串与可空串均可调用
         * isEmpty:字串长度为0时返回true，只有非空串可调用
         * isBlank:字串长度为0或者全为空格时返回true，只有非空串可调用
         * isNotEmpty:字串长度大于0时返回true，只有非空串可调用
         * isNotBlank：字串长度大于0且全不是空格串时返回true，只有非空串可调用
         * 校验空值的运算符：
         * 1、声明变量实例时，在类型名称后加个？，表示该变量可以为空  列如：val length_null:Int?
         * 2、调用该变量方法时，在变量名称后加？，表示一旦变量为空就返回null 列如：  length_null=strB?.length
         * 3、新引入运算符“？：”，表示一旦变量为空，就返回该运算符右边的表达式，返回的变量必须为非空   列如： lengthB=strB?.length?: -1
         * 4、新引入运算符“！！”，通知编译器不做非空校验，如果运行时发现变量为空，就扔出异常 ，这里返回变量必须为非空
         * 列如：try {
        lengthB=strB!!.length
        }catch (e:Exception){

        }
         */
        var float:Float
        button_float.setOnClickListener {
//            float=origin.toDouble().toFloat();button_float.text=float.toString()
            val strA:String="非空"
            val strB:String?=null
            val strC:String?="可空串"
            var lengthA:Int=0
             var lengthB:Int=0
             var lengthC:Int=0
             getlength(strA,strB,strC)

            /* lengthA=strA.length
            lengthB=if (strB!=null) strB.length else -1
            lengthC=if (strC!=null) strC.length else -1
            button_float.text="字符串A的长度为${lengthA}字符串B的长度为${lengthB}字符串C的长度为${lengthC}"*/

        }
        /***
         *
         */
        var isodd = true
        button_double.setOnClickListener {
//            double=origin.toDouble();button_double.text=double.toString()

           /* button_double.text=if (isodd) getFourBigDefault("古代四大发明：","造纸术","印刷术","指南针",
                "火药") else getFourBigDefault("现在四大发明：","高铁","网购","移动支付","共享单车")*/
            /*button_double.text=if (isodd) getFourBigDefault("古代四大发明：","造纸术","印刷术","指南针","火药") else
                getFourBigDefault("古代的七大发明：","造纸术","印刷术","指南针","火药","丝绸","瓷器","茶叶")*/

            button_double.text=if (isodd) getFourBigDefault("古代四大发明：","造纸术","印刷术","指南针","火药") else{
                getFourBigDefault("古代的N大发明：","造纸术","印刷术","指南针","火药", arrayOf("丝绸","瓷器","茶叶"), arrayOf("国画","中医","武术"))}
            isodd = !isodd
        }
        /***
         * 几种特殊函数：泛型函数；内联函数
         */
        var count:Int=0
        var boolean:Boolean
        var int_array:Array<Int> = arrayOf(1,2,3)
        var float_array:Array<Float> = arrayOf(1.0f,2.0f,3.0f)
        var double_array:Array<Double> = arrayOf(11.11,22.22,33.33)
        var string_array:Array<String> = arrayOf("How","do","you","do","I'm    ","Fine")
        button_boolean.setOnClickListener {
//            boolean=origin.isNaN();button_boolean.text=boolean.toString()
            //泛型函数
         /*   button_boolean.text=when (count %3){
              1->appendString<String>("古代四大发明：","造纸术","印刷术","指南针","火药")
              2->appendString<Int>("小于10的素数",2,3,5,7)
              else ->appendString<Double>("烧钱的日子",5.20,6.18,11.11,12.12)
            }
            count++*/
            //内联函数
           /* when(count%3){
                1->setArrayStr(int_array)
                2-> setArrayStr(float_array)
                else -> setArrayStr(double_array)
            }
            count++*/
            //高阶函数
            button_boolean.text=when(count%4){
                0->"字符串数组的默认最大值为${string_array.max()}"
                1->"字符串数组按长度比较最大值为${maxCustom(array_string,{a,b->a.length>b.length})}"
                2->"字符串数组的默认最大值（使用高阶函数）为${maxCustom(array_string,{a,b->a>b})}"
                else->"字符串数组按去掉空格再比较长度的最大值为${maxCustom(array_string,{a,b->a.trim().length>b.trim().length})}"
            }
                count++
        }

        var char:Char
        button_char.setOnClickListener { char=origin.toChar();button_char.text=char.toString() }
        //截取login字符串的数字
      var array_login:CharArray=login.toCharArray()
        for(item in array_login){
            var char :Char=item

        }

//      while (i<array_login.size){
//          var loginchar:Char=array_login.get(i);
//          if (loginchar.equals('"')){
//
//          }
//      }

    }
    fun getlength (strA:String,strB:String?,strC:String?): Int{
        var lengthA:Int=0
        var lengthB:Int=0
        var lengthC:Int=0
        val length_null:Int?
        length_null=strB?.length
        lengthB =strB?.length?: -1
        try {
            lengthB=strB!!.length
        }catch (e:Exception){

        }
        return lengthB
    }
   /* fun getFourBigDefault(general:String="题目",first:String="第一发明",second:String="第二发明",third:String="第三发明",fourth:String="第四发明",vararg args:String?):String{
        var answer:String ="$general: $first，$second，$third，$fourth"
        for (item in args){
            answer="$answer, $item"
        }
        return answer
    }*/
    fun getFourBigDefault(general:String="题目",first:String="第一发明",second:String="第二发明",third:String="第三发明",fourth:String="第四发明",vararg otherArray:Array<String>):String{
        var answer:String ="$general: $first$second$third$fourth"

       for (array in otherArray){
           for (item in array){
               answer="$answer ,$item"
           }
       }
        return answer
    }


    //泛型函数
    fun <T> appendString (tag:String , vararg otherInfo:T?):String{
        var str:String = "$tag:"
        for (item in otherInfo){
            str ="$str${item.toString()}"
        }
        return str
    }
    //内联函数
    inline fun <reified T:Number> setArrayStr(array: Array<T>){
        var str:String="数组元素依次排列"
        for (item in array){
            str=str + item.toString() +","
        }
        button_boolean.text=str
    }
    //简化函数类似三元表达式
    fun factorial (n:Int):Int = if (n <= 1) n else n * factorial(n - 1)

    //尾递归函数：指函数末尾的返回值重复调用了自身函数
    tailrec fun findFixPoint(x:Double =1.0):Double=if (x==Math.cos(x)) x else findFixPoint(Math.cos(x))
    //高阶函数
    fun <T> maxCustom(array: Array<T>,greater: (T,T)->Boolean):T?{
        var max:T? =null
        for (item in array){
            if (max==null||greater(item,max)){
                max=item
            }
        }
        return  max
    }


}
