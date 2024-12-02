package utilities;
    import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {
		public static FileInputStream fi;
		public static FileOutputStream fo; 
		public static XSSFWorkbook wb;
		public static XSSFSheet sh;
		public static XSSFRow ro;
		public static XSSFCell co;
		public static CellStyle st;
		String path;
		
		public  ExcelUtility(String path) {
			this.path=path;
		}
		
		public  int getRowCount(String xlsheet) throws IOException
		{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(xlsheet);
			int rocount=sh.getLastRowNum();
			wb.close();
			fi.close();
			return rocount;
		}
		
		public  int getCellCount(String xlsheet,int roc) throws IOException
		{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(xlsheet);
			ro=sh.getRow(roc);
			int celln=ro.getLastCellNum();
			wb.close();
			fi.close();
			return celln;
		}	
		public  String getCellData(String xlsheet,int roc,int coln) throws IOException	
		{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(xlsheet);
			ro=sh.getRow(roc);
			co=ro.getCell(coln);
			
			String data=co.toString();
			wb.close();
			fi.close();
			return data;
			
		}
		public void setCellData(String xlsheet,int roc,int coln,String data) throws IOException	
		{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(xlsheet);
			ro=sh.getRow(roc);
			
			
			co=ro.createCell(coln);
			co.setCellValue(data);
			
			fo=new FileOutputStream(path);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
		}
		
		public void fillGreenColor(String xlsheet,int roc,int coln) throws IOException	
		{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(xlsheet);
			ro=sh.getRow(roc);
			
			co=ro.createCell(coln);
			st=wb.createCellStyle();
			st.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			st.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			co.setCellStyle(st);
			fo=new FileOutputStream(path);
			wb.write(fo);
			
			wb.close();
			fi.close();
			fo.close();
		}
		
		public  void fillRedColor(String xlsheet,int roc,int coln) throws IOException	
		{
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			sh=wb.getSheet(xlsheet);
			ro=sh.getRow(roc);
			co=ro.createCell(coln);
			st=wb.createCellStyle();
			st.setFillForegroundColor(IndexedColors.RED.getIndex());
			st.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			co.setCellStyle(st);
			fo=new FileOutputStream(path);
			wb.write(fo);
			
			wb.close();
			fi.close();
			fo.close();
		}
		
		
			
			

	}



