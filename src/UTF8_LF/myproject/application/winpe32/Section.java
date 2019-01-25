package myproject.application.winpe32;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.xml.bind.DatatypeConverter;

public class Section {

	String name;
	String strRawAddress;
	int rawAddress;
	int	rawSize;
	String strVirtualAddress;
	int virtualAddress;
	int virtualSize;
	int diff;
	
	public Section(String name) {
		this.name				= name;
		this.strRawAddress		= "";
		this.rawAddress			= 0;
		this.rawSize			= 0;
		this.strVirtualAddress	= "";
		this.virtualAddress		= 0;
		this.virtualSize		= 0;
		this.diff				= 0;
		
	}
	
	public boolean addrCheck(String strStartAddr, int size) {
		
		//アドレスを数値に変換
		int startAddr	= getStringToInt(strStartAddr, false);
		int endAddr		= startAddr + size;
		
		//比較
		if((startAddr>=virtualAddress) && (endAddr<=virtualAddress+virtualSize)){
			return true;
		}else {
			return false;
		}
	}
	
	private int getStringToInt(String str, boolean little) {
		
		int num 			= 0;
		byte[] bytes	 	= null;
		ByteBuffer bytesBuf = null;
		
		bytes	= DatatypeConverter.parseHexBinary(str);
		bytesBuf = ByteBuffer.wrap(bytes);
		
		if(little) {
			bytesBuf.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		if(bytes.length == 2) {
			num	= (int)bytesBuf.getShort(0);
		}else {
			num = bytesBuf.getInt(0);
		}
		
		return num;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrRawAddress() {
		return strRawAddress;
	}

	public void setStrRawAddress(String strRawAddress) {
		this.strRawAddress	= strRawAddress;
		this.rawAddress		= getStringToInt(strRawAddress, false);
	}

	public int getRawAddress() {
		return rawAddress;
	}

	public void setRawAddress(int rawAddress) {
		this.rawAddress = rawAddress;
	}

	public int getRawSize() {
		return rawSize;
	}

	public void setRawSize(int rawSize) {
		this.rawSize = rawSize;
	}

	public String getStrVirtualAddress() {
		return strVirtualAddress;
	}

	public void setStrVirtualAddress(String strVirtualAddress) {
		this.strVirtualAddress 	= strVirtualAddress;
		this.virtualAddress		= getStringToInt(strVirtualAddress, false);
	}

	public int getVirtualAddress() {
		return virtualAddress;
	}

	public void setVirtualAddress(int virtualAddress) {
		this.virtualAddress = virtualAddress;
	}

	public int getVirtualSize() {
		return virtualSize;
	}

	public void setVirtualSize(int virtualSize) {
		this.virtualSize = virtualSize;
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff() {
		this.diff = virtualAddress-rawAddress;
	}
}
