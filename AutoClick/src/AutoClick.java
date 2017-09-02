
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Map;

import jp.jun_nama.test.utf7ime.helper.Utf7ImeHelper;

import com.android.uiautomator.core.Configurator;
import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.core.UiWatcher;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;


public class AutoClick extends UiAutomatorTestCase {
	 // TODO 
	
   public void testDemo() throws UiObjectNotFoundException {
	   //读取配置文件
	   readConfig("mi.txt");
   }
   
   public void test(String str){
	   try{
		   UiObject object;
		   String text = null;
		   String className = "android.widget.EditText";
		   String resourceid = "com.android.mms:id/embedded_text_editor";
		  // object = new UiObject(new UiSelector().resourceId(resourceid).className(className));
		   UiDevice uiDevice=getUiDevice();
		   //点击坐标，在这些界面无法获取控件，所以采用点击坐标的方式
		   uiDevice.click(700,1700);
		   Thread.sleep(2000);
		   object = new UiObject(new UiSelector().className(className).index(2));
		   if(object.exists())
		   {
			   //清除内容，中文每次清一个或两个字
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   object.clearTextField();
			   //输入中文
			   object.setText(Utf7ImeHelper.e(str));
			   Thread.sleep(1000);
			   //点击坐标，在这些界面无法获取控件，所以采用点击坐标的方式
			   UiDevice uidevice=getUiDevice();
			   uidevice.click(300,2400);
			   Thread.sleep(1500);
			   UiDevice uiDevice1=getUiDevice();
			   uiDevice1.click(700,1700);
			   Thread.sleep(1000);
		   }
	   }catch(Exception e) {
		   //exception异常不处理
		   System.out.println(e);
	   }
   }
   
   /**
    * 读取配置文件内容
    * @param configFile 配置文件
    * @return 读取的内容
    * 使用class.getClassLoader().getResourceAsStream方法
 * @throws UiObjectNotFoundException 
    */
   private String readConfig(String configFile) throws UiObjectNotFoundException{
	   BufferedReader reader = null;
		String strData = "";
		try{
			//获取配置文件输入流
			InputStream fileInputStream = AutoClick.class.getClassLoader().getResourceAsStream(configFile);
			if(fileInputStream == null)
			{
				return null;
			}
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			
			//读取
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			//一行行读取
			while((tempString = reader.readLine()) != null){
				strData += tempString;
				test(tempString);
				System.out.println(tempString);
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
		if(reader != null){
			try {
				//关闭
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
		return strData;
   }
}
