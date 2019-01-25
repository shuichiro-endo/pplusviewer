package myproject.application.winpe32;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn.CellEditEvent;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeTableCell;

import javafx.stage.Stage;
import javafx.stage.FileChooser;

import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;
import myproject.application.winpe32.BinTableRecord;
import myproject.application.winpe32.Section;
import myproject.application.winpe32.WinPE32TreeTableRecord;


public class ApplicationController implements Initializable {

	//FXML
	@FXML
	private MenuItem idFileOpen;
	
	@FXML
	private MenuItem idFileExport;
	
	@FXML
	private MenuItem idReadMe;
	
	@FXML
	private MenuItem idInputKey;
	
	@FXML
	private TableView<BinTableRecord> idBinTable;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinLineNo;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin00;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin01;	
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin02;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin03;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin04;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin05;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin06;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin07;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin08;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin09;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0A;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0B;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0C;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0D;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0E;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0F;

	@FXML
	private TableColumn<BinTableRecord, String> idBinSpace;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin0;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin1;	
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin2;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin3;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin4;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin5;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin6;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin7;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin8;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBin9;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinA;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinB;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinC;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinD;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinE;
	
	@FXML
	private TableColumn<BinTableRecord, String> idBinF;	
	
	@FXML
	private Button idRerun;
	
	@FXML
	private TextArea idConsole;
	
	@FXML
	private TreeTableView<WinPE32TreeTableRecord> idWinPE32TreeTableView;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnCheck;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnName;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnRaw;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnRVA;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnOffset;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnSize;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnValue;

	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnAnalysis;
	
	@FXML
	private TreeTableColumn<WinPE32TreeTableRecord, String> idWinPE32TreeTableColumnNotes;
	
	
	
	
	
	
	
	//
	private Stage stage;
	private FileChooser fileOpenChooser		= new FileChooser();
	private FileChooser fileExportChooser	= new FileChooser();
	
	private ObservableList<BinTableRecord> binTableRecordList = FXCollections.observableArrayList();
	private ObservableList<WinPE32TreeTableRecord> winPE32TreeTableRecordList = FXCollections.observableArrayList();
	
	//root
	private String rootName		= "";
	private String rootRaw		= "00000000";
	private String rootOffset	= "00000000";
	private String rootSize		= "00000000";
	private String rootRVA		= "";
	private String rootValue	= "";
	private String rootAnalysis	= "";
	private String rootNotes	= "";
	private TreeItem<WinPE32TreeTableRecord> root;
	
	//notes
	//IMAGE_DOS_HEADER notes
	private String IMAGE_DOS_HEADERNotes	= "";
	private String e_magicNotes				= "";
	private String e_cblpNotes				= "";
	private String e_cpNotes				= "";
	private String e_crlcNotes				= "";
	private String e_charhdrNotes			= "";
	private String e_minallocNotes			= "";
	private String e_maxallocNotes			= "";
	private String e_ssNotes				= "";
	private String e_spNotes				= "";
	private String e_csumNotes				= "";
	private String e_ipNotes				= "";
	private String e_csNotes				= "";
	private String e_lfarlcNotes			= "";
	private String e_ovnoNotes				= "";
	private String e_resNotes				= "";
	private String e_oemidNotes				= "";
	private String e_oeminfoNotes			= "";
	private String e_res2Notes				= "";
	private String e_lfanewNotes			= "";
	
	//IMAGE_NT_HEADER notes
	private String IMAGE_NT_HEADERNotes			= "";
	private String SignatureNotes				= "";
	private String IMAGE_FILE_HEADERNotes		= "";
	private String IMAGE_OPTIONAL_HEADERNotes	= "";
	
	//IMAGE_FILE_HEADER notes
	private String MachineNotes					= "";
	private String NumberOfSectionsNotes		= "";
	private String TimeDataStampNotes			= "";
	private String PointerToSymbolTableNotes	= "";
	private String NumberOfSymbolsNotes			= "";
	private String SizeOfOptionalHeaderNotes	= "";
	private String CharacteristicsNotes			= "";
	
	//IMAGE_OPTIONAL_HEADER notes
	private String MagicNotes						= "";
	private String MajorLinkerVersionNotes			= "";
	private String MinorLinkerVersionNotes			= "";
	private String SizeOfCodeNotes					= "";
	private String SizeOfInitializedDataNotes		= "";
	private String SizeOfUninitializedDataNotes		= "";
	private String AddressOfEntryPointNotes			= "";
	private String BaseOfCodeNotes					= "";
	private String BaseOfDataNotes					= "";
	private String ImageBaseNotes					= "";
	private String SectionAlignmentNotes			= "";
	private String FileAlignmentNotes				= "";
	private String MajorOperatingSystemVersionNotes	= "";
	private String MinorOperatingSystemVersionNotes	= "";
	private String MajorImageVersionNotes			= "";
	private String MinorImageVersionNotes			= "";
	private String MajorSubSystemVersionNotes		= "";
	private String MinorSubSystemVersionNotes		= "";
	private String Win32VersionValueNotes			= "";
	private String SizeOfImageNotes					= "";
	private String SizeOfHeadersNotes				= "";
	private String CheckSumNotes					= "";
	private String SubsystemNotes					= "";
	private String DllCharacteristicsNotes			= "";
	private String SizeOfStackReserveNotes			= "";
	private String SizeOfStackCommitNotes			= "";
	private String SizeOfHeapReserveNotes			= "";
	private String SizeOfHeapCommitNotes			= "";
	private String LoaderFlagsNotes					= "";
	private String NumberOfRvaAndSizesNotes			= "";
	private String DataDirectoryNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_EXPORT notes
	private String IMAGE_DIRECTORY_ENTRY_EXPORTNotes				= "";
	private String IMAGE_DIRECTORY_ENTRY_EXPORTVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_EXPORTSizeNotes			= "";
	
	//IMAGE_DIRECTORY_ENTRY_IMPORT notes
	private String IMAGE_DIRECTORY_ENTRY_IMPORTNotes				= "";
	private String IMAGE_DIRECTORY_ENTRY_IMPORTVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_IMPORTSizeNotes			= "";
	
	//IMAGE_DIRECTORY_ENTRY_RESOURCE notes
	private String IMAGE_DIRECTORY_ENTRY_RESOURCENotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_RESOURCEVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_RESOURCESizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_EXCEPTION notes
	private String IMAGE_DIRECTORY_ENTRY_EXCEPTIONNotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_EXCEPTIONVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_EXCEPTIONSizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_SECURITY notes
	private String IMAGE_DIRECTORY_ENTRY_SECURITYNotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_SECURITYVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_SECURITYSizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_BASERELOC notes
	private String IMAGE_DIRECTORY_ENTRY_BASERELOCNotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_BASERELOCVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_BASERELOCSizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_DEBUG notes
	private String IMAGE_DIRECTORY_ENTRY_DEBUGNotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_DEBUGVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_DEBUGSizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_ARCHITECTURE notes
	private String IMAGE_DIRECTORY_ENTRY_ARCHITECTURENotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_ARCHITECTUREVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_ARCHITECTURESizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_GLOBALPTR notes
	private String IMAGE_DIRECTORY_ENTRY_GLOBALPTRNotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_GLOBALPTRVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_GLOBALPTRSizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_TLS notes
	private String IMAGE_DIRECTORY_ENTRY_TLSNotes				= "";
	private String IMAGE_DIRECTORY_ENTRY_TLSVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_TLSSizeNotes			= "";
	
	//IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG notes
	private String IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGNotes				= "";
	private String IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGSizeNotes			= "";
	
	//IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT notes
	private String IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTNotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTSizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_IAT notes
	private String IMAGE_DIRECTORY_ENTRY_IATNotes				= "";
	private String IMAGE_DIRECTORY_ENTRY_IATVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_IATSizeNotes			= "";
	
	//IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT notes
	private String IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTNotes					= "";
	private String IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTSizeNotes				= "";
	
	//IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR notes
	private String IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORNotes				= "";
	private String IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORVirtualAddressNotes	= "";
	private String IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORSizeNotes			= "";
	
	//IMAGE_SECTION_HEADER notes
	private String IMAGE_SECTION_HEADERNotes						= "";
	private String IMAGE_SECTION_HEADERNameNotes					= "";
	private String IMAGE_SECTION_HEADERVirtualSizeNotes				= "";
	private String IMAGE_SECTION_HEADERVirtualAddressNotes			= "";
	private String IMAGE_SECTION_HEADERSizeOfRawDataNotes			= "";
	private String IMAGE_SECTION_HEADERPointerToRawDataNotes		= "";
	private String IMAGE_SECTION_HEADERPointerToRelocationsNotes	= "";
	private String IMAGE_SECTION_HEADERPointerToLinenumbersNotes	= "";
	private String IMAGE_SECTION_HEADERNumberOfRelocationsNotes		= "";
	private String IMAGE_SECTION_HEADERNumberOfLinenumbersNotes		= "";
	private String IMAGE_SECTION_HEADERCharacteristicsNotes			= "";
	
	//SECTION_DATA notes
	private String SECTION_DATANotes								= "";
	
	//REMAINING_DATA notes
	private String REMAINING_DATANotes								= "";

	//IMAGE_EXPORT_DIRECTORY notes
	private String IMAGE_EXPORT_DIRECTORYNotes						= "";
	private String IMAGE_EXPORT_DIRECTORYCharacteristicsNotes		= "";
	private String IMAGE_EXPORT_DIRECTORYTimeDateStampNotes			= "";
	private String IMAGE_EXPORT_DIRECTORYMajorVersionNotes			= "";
	private String IMAGE_EXPORT_DIRECTORYMinorVersionNotes			= "";
	private String IMAGE_EXPORT_DIRECTORYNameNotes					= "";
	private String IMAGE_EXPORT_DIRECTORYBaseNotes					= "";
	private String IMAGE_EXPORT_DIRECTORYNumberOfFunctionsNotes		= "";
	private String IMAGE_EXPORT_DIRECTORYNumberOfNamesNotes			= "";
	private String IMAGE_EXPORT_DIRECTORYAddressOfFunctionsNotes	= "";
	private String IMAGE_EXPORT_DIRECTORYAddressOfNamesNotes		= "";
	private String IMAGE_EXPORT_DIRECTORYAddressOfNameOrdinalsNotes	= "";
	
	//EXPORT_ADDRESS_TABLE notes
	private String EXPORT_ADDRESS_TABLENotes						= "";
	private String EXPORT_ADDRESS_TABLEAddressOfFunctionNotes		= "";
	
	//EXPORT_NAME_POINTER_TABLE notes
	private String EXPORT_NAME_POINTER_TABLENotes					= "";
	private String EXPORT_NAME_POINTER_TABLEAddressOfNamesNotes		= "";
	
	//EXPORT_ORDINAL_TABLE notes
	private String EXPORT_ORDINAL_TABLENotes						= "";
	private String EXPORT_ORDINAL_TABLEOrdinalsNotes				= "";
	
	//EXPORT_SYMBOL	notes
	private String EXPORT_ADDRESS_TABLEExportSymbolRVANotes		= "";
	private String EXPORT_ADDRESS_TABLEOrdinalNotes				= "";
	private String EXPORT_ADDRESS_TABLEExportSymbolNameNotes	= "";
	private String EXPORT_ADDRESS_TABLEForwardedToNotes			= "";
	
	//IMAGE_IMPORT_DESCRIPTOR notes
	private String IMAGE_IMPORT_DESCRIPTORNotes	= "";	
	private String IMAGE_IMPORT_DESCRIPTOROriginalFirstThunkNotes	= "";
	private String IMAGE_IMPORT_DESCRIPTORTimeDateStampNotes		= "";
	private String IMAGE_IMPORT_DESCRIPTORForwarderChainNotes		= "";
	private String IMAGE_IMPORT_DESCRIPTORNameNotes					= "";
	private String IMAGE_IMPORT_DESCRIPTORFirstThunkNotes			= "";
	private String IMPORTDllNameNotes								= "";			
	
	//IMPORT_NAME_TABLE notes
	private String IMPORT_NAME_TABLENotes							= "";
	private String IMPORT_NAME_TABLEOrdinalNotes					= "";
	private String IMPORT_NAME_TABLEAddressOfDataNotes				= "";
	
	//IMAGE_IMPORT_BY_NAME notes
	private String IMAGE_IMPORT_BY_NAMENotes						= "";
	private String IMAGE_IMPORT_BY_NAMEHintNotes					= "";
	private String IMAGE_IMPORT_BY_NAMENAMENotes					= "";
	
	//IMPORT_ADDRESS_TABLE notes
	private String IMPORT_ADDRESS_TABLENotes						= "";
	private String IMPORT_ADDRESS_TABLEOrdinalNotes					= "";
	private String IMPORT_ADDRESS_TABLEAddressOfDataNotes			= "";
	
	//IMAGE_RESOURCE_DIRECTORY notes
	private String IMAGE_RESOURCE_DIRECTORYNotes					= "";
	private String IMAGE_RESOURCE_DIRECTORYCharacteristicsNotes		= "";
	private String IMAGE_RESOURCE_DIRECTORYTimeDateStampNotes		= "";
	private String IMAGE_RESOURCE_DIRECTORYMajorVersionNotes		= "";
	private String IMAGE_RESOURCE_DIRECTORYMinorVersionNotes		= "";
	private String IMAGE_RESOURCE_DIRECTORYNumberOfNameEntriesNotes	= "";
	private String IMAGE_RESOURCE_DIRECTORYNumberOfIdEntriesNotes	= "";
	
	//RESOURCE_DIRECTORY_ENTRY notes
	private String RESOURCE_DIRECTORY_ENTRYNotes					= "";
	private String RESOURCE_DIRECTORY_ENTRYNameRVANotes				= "";
	private String RESOURCE_DIRECTORY_ENTRYIDNotes					= "";
	private String RESOURCE_DIRECTORY_ENTRYDataEntryRVANotes		= "";
	private String RESOURCE_DIRECTORY_ENTRYSubdirectoryRVANotes		= "";
	
	//RESOURCE_DIRECTRY_STRING notes
	private String RESOURCE_DIRECTRY_STRINGNotes					= "";
	private String RESOURCE_DIRECTRY_STRINGLengthNotes				= "";
	private String RESOURCE_DIRECTRY_STRINGUnicodeStringNotes		= "";

	//RESOURCE_DATA_ENTRY notes
	private String RESOURCE_DATA_ENTRYNotes							= "";
	private String RESOURCE_DATA_ENTRYDataRVANotes					= "";
	private String RESOURCE_DATA_ENTRYSizeNotes						= "";
	private String RESOURCE_DATA_ENTRYCodePageNotes					= "";
	private String RESOURCE_DATA_ENTRYReservedNotes					= "";
	private String RESOURCE_DATANotes								= "";
	
	//FUNCTION_TABLE_ENTRY notes
	private String FUNCTION_TABLE_ENTRY_MIPS32Notes					= "";
	private String FUNCTION_TABLE_ENTRY_MIPS32BeginAddressNotes		= "";
	private String FUNCTION_TABLE_ENTRY_MIPS32EndAddressNotes		= "";
	private String FUNCTION_TABLE_ENTRY_MIPS32ExceptionHandlerNotes	= "";
	private String FUNCTION_TABLE_ENTRY_MIPS32HandlerDataNotes		= "";
	private String FUNCTION_TABLE_ENTRY_MIPS32PrologEndAddressNotes	= "";
	private String FUNCTION_TABLE_ENTRY_CENotes						= "";
	private String FUNCTION_TABLE_ENTRY_CEBeginAddressNotes			= "";
	private String FUNCTION_TABLE_ENTRY_CEPrologLengthNotes			= "";
	private String FUNCTION_TABLE_ENTRY_CEFunctionLengthNotes		= "";
	private String FUNCTION_TABLE_ENTRY_CEbitFlagNotes				= "";
	private String FUNCTION_TABLE_ENTRY_CEExceptionFlagNotes		= "";
	private String FUNCTION_TABLE_ENTRY_x64Notes					= "";
	private String FUNCTION_TABLE_ENTRY_x64BeginAddressNotes		= "";
	private String FUNCTION_TABLE_ENTRY_x64EndAddressNotes			= "";
	private String FUNCTION_TABLE_ENTRY_x64UnwindInformationNotes	= "";
	private String FUNCTION_TABLE_ENTRY_ARMV7Notes					= "";
	private String FUNCTION_TABLE_ENTRY_ARMV7BeginAddressNotes		= "";
	private String FUNCTION_TABLE_ENTRY_ARMV7UnwindInformationNotes	= "";
	
	//ATTRIBUTE_CERTIFICATE_ENTRY notes
	private String ATTRIBUTE_CERTIFICATE_ENTRYNotes					= "";
	private String ATTRIBUTE_CERTIFICATE_ENTRYdwLengthNotes			= "";
	private String ATTRIBUTE_CERTIFICATE_ENTRYwRevisionNotes		= "";
	private String ATTRIBUTE_CERTIFICATE_ENTRYwCertificateTypeNotes	= "";
	private String ATTRIBUTE_CERTIFICATE_ENTRYbCertificateNotes		= "";
	
	//IMAGE_BASE_RELOCATION notes
	private String IMAGE_BASE_RELOCATIONNotes						= "";
	
	//BASE_RELOCATION_BLOCK notes
	private String BASE_RELOCATION_BLOCKNotes						= "";
	private String BASE_RELOCATION_BLOCKVirtualAddressNotes			= "";
	private String BASE_RELOCATION_BLOCKSizeOfBlockNotes			= "";
	private String BASE_RELOCATION_BLOCKTypeOffsetNotes				= "";
	
	//DEBUG_DIRECTRY_ENTRY notes
	private String IMAGE_DEBUG_DIRECTRYNotes						= "";
	private String DEBUG_DIRECTRY_ENTRYCharacteristicsNotes			= "";
	private String DEBUG_DIRECTRY_ENTRYTimeDateStampNotes			= "";
	private String DEBUG_DIRECTRY_ENTRYMajorVersionNotes			= "";
	private String DEBUG_DIRECTRY_ENTRYMinorVersionNotes			= "";
	private String DEBUG_DIRECTRY_ENTRYTypeNotes					= "";
	private String DEBUG_DIRECTRY_ENTRYSizeOfDataNotes				= "";
	private String DEBUG_DIRECTRY_ENTRYAddressOfRawDataNotes		= "";
	private String DEBUG_DIRECTRY_ENTRYPointerToRawDataNotes		= "";
	
	//DEBUG_DATA notes
	private String DEBUG_DATANotes									= "";
	
	//IMAGE_TLS_DIRECTORY notes
	private String IMAGE_TLS_DIRECTORYNotes							= "";
	private String IMAGE_TLS_DIRECTORYStartAddressOfRawDataNotes	= "";
	private String IMAGE_TLS_DIRECTORYEndAddressOfRawDataNotes		= "";
	private String IMAGE_TLS_DIRECTORYAddressOfIndexNotes			= "";
	private String IMAGE_TLS_DIRECTORYAddressOfCallBacksNotes		= "";
	private String IMAGE_TLS_DIRECTORYSizeOfZeroFillNotes			= "";
	private String IMAGE_TLS_DIRECTORYCharacteristicsNotes			= "";	
	
	//IMAGE_LOAD_CONFIG_DIRECTORY notes
	private String IMAGE_LOAD_CONFIG_DIRECTORYNotes									= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYCharacteristicsNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYTimeDateStampNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYMajorVersionNotes						= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYMinorVersionNotes						= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYGlobalFlagsClearNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYGlobalFlagsSetNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYCriticalSectionDefaultTimeoutNotes	= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYDecommitFreeBloackThresholdNotes		= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYDecommitTotalFreeThresholdNotes		= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYLockPrefixTableNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYMaximumAllocationSizeNotes			= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYVirtualMemoryThresholdNotes			= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYProcessHeapFlagsNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYProcessAffinityMaskNotes				= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYCSDVersionNotes						= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYReserved1Notes						= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYEditListNotes							= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYSecurityCookieNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYSEHandlerTableNotes					= "";
	private String IMAGE_LOAD_CONFIG_DIRECTORYSEHandlerCountNotes					= "";
	
	//IMAGE_DELAY_IMPORT_DESCRIPTOR notes
	private String IMAGE_DELAY_IMPORT_DESCRIPTORNotes				= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORgrAttrsNotes		= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORszNameNotes			= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORphmodNotes			= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORpIATNotes			= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORpINTNotes			= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORpBoundIATNotes		= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORpUnloadIATNotes		= "";
	private String IMAGE_DELAY_IMPORT_DESCRIPTORdwTimeStampNotes	= "";
	
	//DELAY_IMPORT notes
	private String DELAY_IMPORTDllNameNotes							= "";

	//DELAY_IMPORT_ADDRESS_TABLE notes
	private String DELAY_IMPORT_ADDRESS_TABLENotes					= "";
	private String DELAY_IMPORT_ADDRESS_TABLEFunctionNotes			= "";
	
	//DELAY_IMPORT_NAME_TABLE notes
	private String DELAY_IMPORT_NAME_TABLENotes						= "";
	private String DELAY_IMPORT_NAME_TABLEOrdinalNotes				= "";
	private String DELAY_IMPORT_NAME_TABLEAddressOfDataNotes		= "";

	//DELAY_BOUND_IMPORT_ADDRESS_TABLE notes
	private String DELAY_BOUND_IMPORT_ADDRESS_TABLENotes				= "";
	private String DELAY_BOUND_IMPORT_ADDRESS_TABLEOrdinalNotes			= "";
	private String DELAY_BOUND_IMPORT_ADDRESS_TABLEAddressOfDataNotes	= "";
	
	//DELAY_UNLOAD_IMPORT_ADDRESS_TABLE notes
	private String DELAY_UNLOAD_IMPORT_ADDRESS_TABLENotes				= "";
	private String DELAY_UNLOAD_IMPORT_ADDRESS_TABLEOrdinalNotes		= "";
	private String DELAY_UNLOAD_IMPORT_ADDRESS_TABLEAddressOfDataNotes	= "";

	
	//サイズ定数
	private final static int BYTE		= 0x1;
	private final static int WORD 		= 0x2;
	private final static int DWORD		= 0x4;
	private final static int ULONGLONG	= 0x8;
	
	//構造体サイズ
	private int IMAGE_DOS_HEADER_SIZE				= 0;
	private int IMAGE_FILE_HEADER_SIZE				= 0;
	private int IMAGE_OPTIONAL_HEADER_SIZE			= 0;
	private int IMAGE_NT_HEADER_SIZE				= 0;
	private int IMAGE_DATA_DIRECTORY_SIZE			= 0;
	private int IMAGE_SECTION_HRADER_SIZE			= 0;
	private int IMAGE_EXPORT_DIRECTORY_SIZE			= 0;
	private int IMAGE_IMPORT_DESCRIPTOR_SIZE		= 0;	
	private int PIMAGE_THUNK_DATA_SIZE				= 0;
	private int IMAGE_THUNK_DATA32_SIZE				= 0;
	private int IMAGE_THUNK_DATA64_SIZE				= 0;
	private int IMAGE_RESOURCE_DIRECTORY_SIZE		= 0;
	private int RESOURCE_DIRECTORY_ENTRY_SIZE		= 0;
	private int RESOURCE_DATA_ENTRY_SIZE			= 0;
	private int IMAGE_ALPHA_RUNTIME_FUNCTION_ENTRY_SIZE		= 0;
	private int IMAGE_CE_RUNTIME_FUNCTION_ENTRY_SIZE		= 0;
	private int IMAGE_RUNTIME_FUNCTION_ENTRY_SIZE			= 0;
	private int IMAGE_ARMV7_RUNTIME_FUNCTION_ENTRY_SIZE		= 0;
	private int IMAGE_DEBUG_DIRECTRY_SIZE					= 0;
	private int IMAGE_TLS_DIRECTORY32_SIZE					= 0;
	private int IMAGE_TLS_DIRECTORY64_SIZE					= 0;
	private int PIMAGE_TLS_CALLBACK32_SIZE					= 0;
	private int PIMAGE_TLS_CALLBACK64_SIZE					= 0;
	private int IMAGE_LOAD_CONFIG_DIRECTORY32_SIZE			= 0;
	private int IMAGE_LOAD_CONFIG_DIRECTORY64_SIZE			= 0;
	
	
	private int IMAGE_DELAY_IMPORT_DESCRIPTOR_SIZE			= 0;
	
	
	//
	private int IMAGE_SIZEOF_SHORT_NAME	= 8;
	
	
	//先頭アドレス
	private String IMAGE_DOS_HEADER_START_ADDR						= "00000000";
	private String IMAGE_NT_HEADER_START_ADDR						= "";
	private String IMAGE_FILE_HEADER_START_ADDR						= "";
	private String IMAGE_OPTIONAL_HEADER_START_ADDR					= "";
	private String IMAGE_DIRECTORY_ENTRY_EXPORT_START_ADDR			= "";
	private String IMAGE_DIRECTORY_ENTRY_IMPORT_START_ADDR			= "";	
	private String IMAGE_DIRECTORY_ENTRY_RESOURCE_START_ADDR		= "";	
	private String IMAGE_DIRECTORY_ENTRY_EXCEPTION_START_ADDR		= "";	
	private String IMAGE_DIRECTORY_ENTRY_SECURITY_START_ADDR		= "";	
	private String IMAGE_DIRECTORY_ENTRY_BASERELOC_START_ADDR		= "";	
	private String IMAGE_DIRECTORY_ENTRY_DEBUG_START_ADDR			= "";	
	private String IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_START_ADDR	= "";	
	private String IMAGE_DIRECTORY_ENTRY_GLOBALPTR_START_ADDR		= "";	
	private String IMAGE_DIRECTORY_ENTRY_TLS_START_ADDR				= "";	
	private String IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_START_ADDR		= "";	
	private String IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_START_ADDR	= "";	
	private String IMAGE_DIRECTORY_ENTRY_IAT_START_ADDR				= "";	
	private String IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_START_ADDR	= "";	
	private String IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_START_ADDR	= "";
	private String IMAGE_SECTION_HEADER_START_ADDR					= "";
	
	//Item
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_EXPORT_ITEM			= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_IMPORT_ITEM			= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_RESOURCE_ITEM		= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_EXCEPTION_ITEM		= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_SECURITY_ITEM		= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_BASERELOC_ITEM		= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_DEBUG_ITEM			= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_ITEM	= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_GLOBALPTR_ITEM		= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_TLS_ITEM				= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_ITEM		= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_ITEM	= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_IAT_ITEM				= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_ITEM	= null;
	private TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_ITEM	= null;
	
	//RVA、SIZE
	private String IMAGE_DIRECTORY_ENTRY_EXPORT_RVA			= "";
	private String IMAGE_DIRECTORY_ENTRY_IMPORT_RVA			= "";	
	private String IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA		= "";	
	private String IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA		= "";	
	private String IMAGE_DIRECTORY_ENTRY_SECURITY_RVA		= "";	
	private String IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA		= "";	
	private String IMAGE_DIRECTORY_ENTRY_DEBUG_RVA			= "";	
	private String IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_RVA	= "";	
	private String IMAGE_DIRECTORY_ENTRY_GLOBALPTR_RVA		= "";	
	private String IMAGE_DIRECTORY_ENTRY_TLS_RVA			= "";	
	private String IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA	= "";	
	private String IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_RVA	= "";	
	private String IMAGE_DIRECTORY_ENTRY_IAT_RVA			= "";	
	private String IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA	= "";	
	private String IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_RVA	= "";
	
	private int IMAGE_DIRECTORY_ENTRY_EXPORT_RVA_SIZE			= 0;
	private int IMAGE_DIRECTORY_ENTRY_IMPORT_RVA_SIZE			= 0;
	private int IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA_SIZE			= 0;
	private int IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA_SIZE		= 0;
	private int IMAGE_DIRECTORY_ENTRY_SECURITY_RVA_SIZE			= 0;
	private int IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA_SIZE		= 0;
	private int IMAGE_DIRECTORY_ENTRY_DEBUG_RVA_SIZE			= 0;
	private int IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_RVA_SIZE		= 0;
	private int IMAGE_DIRECTORY_ENTRY_GLOBALPTR_RVA_SIZE		= 0;
	private int IMAGE_DIRECTORY_ENTRY_TLS_RVA_SIZE				= 0;
	private int IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA_SIZE		= 0;
	private int IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_RVA_SIZE		= 0;
	private int IMAGE_DIRECTORY_ENTRY_IAT_RVA_SIZE				= 0;
	private int IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA_SIZE		= 0;
	private int IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_RVA_SIZE	= 0;
	
	//セクション数
	private int sectionCount	= 0;
	
	//セクション情報格納
	private ArrayList<Section> sectionList	= null;
	
	//残りデータ情報
	private String remainingDataRawAddr	= "";
	private int reaminingDataRawSize		= 0;
	
	//Magic number
	private String magicNumber	= "";
	
	//ターゲットプラットフォーム
	private String targetPlatform	= "";
	
	//
	
	//ハイライト用
	private int highlightStartAddr	= 0;
	private int highlightEndAddr	= 0;
	
	
	public ApplicationController(Stage stage) {
		this.stage = stage;
		fileOpenChooser.setTitle("File Open");
		fileExportChooser.setTitle("File Export");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//機能停止
		idFileExport.setDisable(true);
		idBinTable.setEditable(false);
		idRerun.setDisable(true);
	}
	
	@FXML
	protected void onFileOpen(ActionEvent evt) {
		
		idConsole.clear();
		
		//バイナリテーブル表示
		boolean b	= binTableShow();
		
		//PE解析、表示
		if(b) {
			win32PETreeTableShow();
		}else {
			idConsole.setText("Please select a file to open.");
		}
	}
	
	@FXML
	protected void onFileExport(ActionEvent evt){
		
		idConsole.clear();
		
		int lastLineno	= binTableRecordList.size()-1;
		
		if(lastLineno>-1){
			
			int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();	
			int byteCount	= lastLineno*16+lastByteNum;
					
//			System.out.println("lastLineno="+lastLineno);
//			System.out.println("lastByteNum="+lastByteNum);
//			System.out.println("byteCount="+byteCount);
			
			File outputBinFile	= fileExportChooser.showSaveDialog(stage);
			
			if(outputBinFile!=null){
				
				try{
					
					FileOutputStream fos		= new FileOutputStream(outputBinFile);
					BufferedOutputStream bos	= new BufferedOutputStream(fos);
					
					//出力データの作成
					byte[] outputData	= getBintableBytes(0, byteCount);
					
					bos.write(outputData);
					
					bos.flush();
					bos.close();
					
				}catch(Exception e){
					
					String message	= "An error occured.";	
//					message.concat("Please look at the error file(error.txt).");
					idConsole.setText(message);
					
					String alertType				= "ERROR";
					String title					= "ERROR";
					String headerText				= "ERROR";
					String contentText				= "An error occured.";
					StringWriter sw	= new StringWriter();
					e.printStackTrace(new PrintWriter(sw));
					String expandableContentText	= sw.toString();
				
					alertMessageBox(alertType, title, headerText, contentText, expandableContentText);					
				}
			}else{
				idConsole.setText("Please select a file to export.");
			}			
		}else{
			idConsole.setText("There are no export data.");
		}
	}
	
	@FXML
	protected void onMouseClickedWinPE32TreeTableView(MouseEvent evt) {
		
		TreeItem<WinPE32TreeTableRecord> item	= idWinPE32TreeTableView.getSelectionModel().getSelectedItem();

		if(item != null) {
			WinPE32TreeTableRecord record	= item.getValue();
			String strStartAddr				= record.getRaw();
			String strSize					= record.getSize();
			int startAddr					= 0;
			int size						= 0;
			int endAddr						= 0;	
			int lineno						= 0;
			
//			System.out.println("startAddr="+startAddr);
//			System.out.println("size="+size);
			
			//アドレスがあれば
			if(!strStartAddr.equals("") && !strSize.equals("00000000")){
				startAddr					= getStringToInt(strStartAddr, false);
				size						= getStringToInt(strSize, false);
				endAddr						= startAddr+size;		
				lineno						= startAddr/16;
				
				//行移動
				BinTableRecord binTableRecord 	= idBinTable.getItems().get(lineno);
				idBinTable.scrollTo(binTableRecord);
				
				//ハイライト
				highlightStartAddr	= startAddr;
				highlightEndAddr	= endAddr;			
				idBinTable.refresh();	
			
			}
		}		
	}
	
	@FXML
	protected void onRerun(ActionEvent evt){
		
		idConsole.clear();
		
		//PE解析、表示
		if(binTableRecordList.size()!=0) {
			win32PETreeTableShow();
		}

	}
	
	
	private boolean binTableShow() {
		
		try {
			File inputBinFile 		= fileOpenChooser.showOpenDialog(stage);
			
			if(inputBinFile == null) {
				return false;
			}
				
			FileInputStream fis 	= new FileInputStream(inputBinFile);
			BufferedInputStream bis = new BufferedInputStream(fis);	
			
			rootName				= inputBinFile.getName();
			
			int rb 					= 0;
			int bytecount			= 0;
			int lineno				= 0;	
			String hexStr			= null;
			String charStr			= null;
			ByteBuffer buffer		= null;
			
			if(binTableRecordList.size() != 0 ) {
				binTableRecordList.clear();
			}
			
			if(winPE32TreeTableRecordList.size() != 0) {
				winPE32TreeTableRecordList.clear();
			}
			
			//1レコード目
			BinTableRecord	record	= new BinTableRecord(String.format("%08X", lineno));
			binTableRecordList.add(record);

			while((rb = bis.read()) != -1) {
				switch (bytecount) {
					case 0:
						//2レコード目以降
						if(lineno != 0){
							record	= new BinTableRecord(String.format("%08X", lineno));
							binTableRecordList.add(record);
							//System.out.println("lineno="+String.format("%08X", lineno));
						}
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", );
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						
						//System.out.println(hexStr);
						record.setBin00(hexStr);
						record.setBin0(charStr);
						
						//初期データ保存
						record.setBin00Old(hexStr);
						record.setBin0Old(charStr);
						
						bytecount++;
						
						//次レコードのため
						lineno += 16;
						break;
					case 1:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
						
						//System.out.println(hexStr);
						record.setBin01(hexStr);	
						record.setBin1(charStr);
						
						//初期データ保存
						record.setBin01Old(hexStr);
						record.setBin1Old(charStr);
						
						bytecount++;
						break;
					case 2:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin02(hexStr);
						record.setBin2(charStr);
						
						//初期データ保存
						record.setBin02Old(hexStr);
						record.setBin2Old(charStr);
						
						bytecount++;
						break;
					case 3:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin03(hexStr);
						record.setBin3(charStr);
						
						//初期データ保存
						record.setBin03Old(hexStr);
						record.setBin3Old(charStr);
						
						bytecount++;
						break;
					case 4:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin04(hexStr);
						record.setBin4(charStr);
						
						//初期データ保存
						record.setBin04Old(hexStr);
						record.setBin4Old(charStr);
						
						bytecount++;
						break;
					case 5:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin05(hexStr);
						record.setBin5(charStr);
						
						//初期データ保存
						record.setBin05Old(hexStr);
						record.setBin5Old(charStr);
						
						bytecount++;
						break;
					case 6:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin06(hexStr);
						record.setBin6(charStr);
						
						//初期データ保存
						record.setBin06Old(hexStr);
						record.setBin6Old(charStr);
						
						bytecount++;
						break;
					case 7:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin07(hexStr);
						record.setBin7(charStr);
						
						//初期データ保存
						record.setBin07Old(hexStr);
						record.setBin7Old(charStr);
						
						bytecount++;
						break;
					case 8:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin08(hexStr);
						record.setBin8(charStr);
						
						//初期データ保存
						record.setBin08Old(hexStr);
						record.setBin8Old(charStr);
						
						bytecount++;
						break;
					case 9:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin09(hexStr);
						record.setBin9(charStr);
						
						//初期データ保存
						record.setBin09Old(hexStr);
						record.setBin9Old(charStr);
						
						bytecount++;
						break;
					case 10:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin0A(hexStr);
						record.setBinA(charStr);
						
						//初期データ保存
						record.setBin0AOld(hexStr);
						record.setBinAOld(charStr);
						
						bytecount++;
						break;
					case 11:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin0B(hexStr);
						record.setBinB(charStr);
						
						//初期データ保存
						record.setBin0BOld(hexStr);
						record.setBinBOld(charStr);
						
						bytecount++;
						break;
					case 12:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin0C(hexStr);
						record.setBinC(charStr);
						
						//初期データ保存
						record.setBin0COld(hexStr);
						record.setBinCOld(charStr);
						
						bytecount++;
						break;
					case 13:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin0D(hexStr);
						record.setBinD(charStr);
						
						//初期データ保存
						record.setBin0DOld(hexStr);
						record.setBinDOld(charStr);
						
						bytecount++;
						break;
					case 14:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin0E(hexStr);
						record.setBinE(charStr);
						
						//初期データ保存
						record.setBin0EOld(hexStr);
						record.setBinEOld(charStr);
						
						bytecount++;
						break;
					case 15:
						hexStr = String.format("%02X", rb & 0xff).toUpperCase();
						//charStr = String.format("%c", rb & 0xff);
						buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
						charStr = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");

						//System.out.println(hexStr);
						record.setBin0F(hexStr);
						record.setBinF(charStr);
						
						//初期データ保存
						record.setBin0FOld(hexStr);
						record.setBinFOld(charStr);
						
						bytecount = 0;
						break;
					default:
						break;			
				}				
			}

			bis.close();
			fis.close();
			
		} catch(Exception e) {
			
//			try{
//				StringWriter sw	= new StringWriter();
//				e.printStackTrace(new PrintWriter(sw));	
//				File errorFile			= new File("error.txt");
//				FileWriter fileWriter	= new FileWriter(errorFile);
//				fileWriter.write(sw.toString());
//				fileWriter.close();
//			}catch(Exception e2) {
//				e.printStackTrace();
//			}
		
			String message	= "An error occured.";	
//			message.concat("Please look at the error file(error.txt).");
			idConsole.setText(message);
			
			String alertType				= "ERROR";
			String title					= "ERROR";
			String headerText				= "ERROR";
			String contentText				= "An error occured.";
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String expandableContentText	= sw.toString();
		
			alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
								
		}

		idBinLineNo.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("lineno"));
		idBin00.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin00"));
		idBin01.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin01"));
		idBin02.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin02"));
		idBin03.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin03"));
		idBin04.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin04"));
		idBin05.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin05"));
		idBin06.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin06"));
		idBin07.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin07"));
		idBin08.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin08"));
		idBin09.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin09"));
		idBin0A.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0A"));
		idBin0B.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0B"));
		idBin0C.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0C"));
		idBin0D.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0D"));
		idBin0E.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0E"));
		idBin0F.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0F"));
//		idBinSpace.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binspace"));
		idBin0.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin0"));
		idBin1.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin1"));
		idBin2.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin2"));
		idBin3.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin3"));
		idBin4.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin4"));
		idBin5.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin5"));
		idBin6.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin6"));
		idBin7.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin7"));
		idBin8.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin8"));
		idBin9.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("bin9"));
		idBinA.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binA"));
		idBinB.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binB"));
		idBinC.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binC"));
		idBinD.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binD"));
		idBinE.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binE"));
		idBinF.setCellValueFactory(new PropertyValueFactory<BinTableRecord, String>("binF"));
	
		idBin00.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin00(record.getBin00Old());
								record.setBin0(record.getBin0Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin00.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin00(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin01.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin01(record.getBin01Old());
								record.setBin1(record.getBin1Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin01.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin01(newData);
						
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin1(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
			
		idBin02.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin02(record.getBin02Old());
								record.setBin2(record.getBin2Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin02.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin02(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin2(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin03.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin03(record.getBin03Old());
								record.setBin3(record.getBin3Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin03.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin03(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin3(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin04.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin04(record.getBin04Old());
								record.setBin4(record.getBin4Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin04.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin04(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin4(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin05.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin05(record.getBin05Old());
								record.setBin5(record.getBin5Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin05.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin05(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin5(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin06.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin06(record.getBin06Old());
								record.setBin6(record.getBin6Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin06.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin06(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin6(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin07.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin07(record.getBin07Old());
								record.setBin7(record.getBin7Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin07.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin07(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin7(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin08.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin08(record.getBin08Old());
								record.setBin8(record.getBin8Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin08.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin08(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin8(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin09.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin09(record.getBin09Old());
								record.setBin9(record.getBin9Old());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin09.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin09(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin9(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0A.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0A(record.getBin0AOld());
								record.setBinA(record.getBinAOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0A.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0A(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinA(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0B.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0B(record.getBin0BOld());
								record.setBinB(record.getBinBOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0B.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0B(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinB(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0C.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0C(record.getBin0COld());
								record.setBinC(record.getBinCOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0C.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0C(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinC(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0D.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0D(record.getBin0DOld());
								record.setBinD(record.getBinDOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0D.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0D(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinD(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0E.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0E(record.getBin0EOld());
								record.setBinE(record.getBinEOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0E.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0E(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinE(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
		idBin0F.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						final EditBinTableCell cell = new EditBinTableCell(new DefaultStringConverter());						
						ContextMenu contextMenu	= new ContextMenu();
						cell.setContextMenu(contextMenu);
						MenuItem menuItem	= new MenuItem("InitialValue");
						menuItem.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent e){
								int cellrow				= cell.getTableRow().getIndex();							
								BinTableRecord record	= cell.getTableView().getItems().get(cellrow);
								
								record.setBin0F(record.getBin0FOld());
								record.setBinF(record.getBinFOld());
								
								//再表示
								idBinTable.refresh();
							}
						});
						contextMenu.getItems().add(menuItem);
						
						cell.graphicProperty().addListener(new InvalidationListener(){
							@Override
							public void invalidated(Observable arg0){
								if(cell.getGraphic() instanceof TextField){
									((TextField)cell.getGraphic()).setContextMenu(cell.getContextMenu());;
								}
							}});
						return cell;
					}});
		idBin0F.setOnEditCommit(new EventHandler<CellEditEvent<BinTableRecord, String>>() {
			@Override
			public void handle(CellEditEvent<BinTableRecord, String> t) {
				
				String newData	= t.getNewValue();
				Pattern p		= Pattern.compile("^[0-9A-F]{2}$");

				if(newData.length()==2){
					Matcher m	= p.matcher(newData);
					if(m.find()){
						((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBin0F(newData);
					
						try{
							byte[] data	= DatatypeConverter.parseHexBinary(newData);							
							int rb		= (int)data[0];
							ByteBuffer buffer	= ByteBuffer.allocate(Integer.SIZE/Byte.BYTES);
							String newCharData = new String(buffer.putInt(rb&0xff).array(), "US-ASCII");
							
							((BinTableRecord) t.getTableView().getItems().get(t.getTablePosition().getRow())).setBinF(newCharData);
														
						}catch(Exception e){
							
							String message	= "An error occured.";	
//							message.concat("Please look at the error file(error.txt).");
							idConsole.setText(message);
							
							String alertType				= "ERROR";
							String title					= "ERROR";
							String headerText				= "ERROR";
							String contentText				= "An error occured.";
							StringWriter sw	= new StringWriter();
							e.printStackTrace(new PrintWriter(sw));
							String expandableContentText	= sw.toString();
						
							alertMessageBox(alertType, title, headerText, contentText, expandableContentText);

						}
					}
				}
				//再表示
				idBinTable.refresh();
			}
		});	
		
//		idBinSpace.setCellFactory(
//				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
//					@Override
//					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
//						return new BinTableCell();
//					}});
		
		idBin0.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBin1.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin2.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin3.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin4.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin5.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
		idBin6.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});	
		idBin7.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBin8.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBin9.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinA.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinB.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinC.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinD.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinE.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});
		idBinF.setCellFactory(
				new Callback<TableColumn<BinTableRecord, String>, TableCell<BinTableRecord, String>>(){
					@Override
					public TableCell<BinTableRecord, String> call(TableColumn<BinTableRecord, String> record) {	
						return new BinTableCell();
					}});		
			
		idBinTable.setItems(binTableRecordList);		
		
		return true;
	}
	
	public class EditBinTableCell extends TextFieldTableCell<BinTableRecord, String> {
		
		EditBinTableCell(StringConverter<String> converter){
			super(converter);			
		}		
		
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			
			int cellrow		= getTableRow().getIndex();
			int cellcolumn	= Integer.parseInt(getTableColumn().getText(), 16);		
			int cellno		= cellrow*16+cellcolumn;
						
//			System.out.println("cellno="+ Integer.toHexString(cellno));
//			System.out.println("highlightStartAddr="+ Integer.toHexString(highlightStartAddr));
//			System.out.println("highlightEndAddr="+ Integer.toHexString(highlightEndAddr));
			
			if(item != null) {
				if(cellno ==0 && highlightStartAddr == 0) {
					setText(item.toString());			
					getStyleClass().clear();
										
					if(binTableRecordList.get(cellrow).getBin0OldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}
				
				}else if(cellno >= highlightStartAddr && cellno < highlightEndAddr) {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBin0OldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}

				}else {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBin0OldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell");
					}else {
						getStyleClass().add("bin-table-cell-change");
					}
					
				}
				
//				if(cellno == highlightStartAddr) {
//					BinTableRecord binTableRecord 	= getTableView().getItems().get(cellno);
//					getTableView().scrollTo(binTableRecord);
					
//					getTableView().getSelectionModel().setCellSelectionEnabled(true);
//					getTableView().requestFocus();
//					getTableView().getSelectionModel().select(cellrow, getTableColumn());
//				}
			}
		}
		
		
		
		
	};
	
	public class BinTableCell extends TableCell<BinTableRecord, String> {
		
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			
			int cellrow		= getTableRow().getIndex();
			int cellcolumn	= Integer.parseInt(getTableColumn().getText(), 16);		
			int cellno		= cellrow*16+cellcolumn;
						
//			System.out.println("cellno="+ Integer.toHexString(cellno));
//			System.out.println("highlightStartAddr="+ Integer.toHexString(highlightStartAddr));
//			System.out.println("highlightEndAddr="+ Integer.toHexString(highlightEndAddr));
			
			
			if(item != null) {
				if(cellno ==0 && highlightStartAddr == 0) {
					setText(item.toString());			
					getStyleClass().clear();
										
					if(binTableRecordList.get(cellrow).getBinOldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}
				
				}else if(cellno >= highlightStartAddr && cellno < highlightEndAddr) {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBinOldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell-highlight");
					}else {
						getStyleClass().add("bin-table-cell-highlight-change");
					}

				}else {
					setText(item.toString());
					getStyleClass().clear();
					
					if(binTableRecordList.get(cellrow).getBinOldData(cellcolumn).equals(item.toString())){
						getStyleClass().add("bin-table-cell");
					}else {
						getStyleClass().add("bin-table-cell-change");
					}
					
				}
			
//			if(item != null) {
//				if(cellno ==0 && highlightStartAddr == 0) {
//					setText(item.toString());			
//					getStyleClass().clear();
//					getStyleClass().add("bin-table-cell-highlight");
//				}else if(cellno >= highlightStartAddr && cellno < highlightEndAddr) {
//					setText(item.toString());
//					getStyleClass().clear();
//					getStyleClass().add("bin-table-cell-highlight");
//				}else {
//					setText(item.toString());
//					getStyleClass().clear();
//					getStyleClass().add("bin-table-cell");
//				}
				
//				if(cellno == highlightStartAddr) {
//					BinTableRecord binTableRecord 	= getTableView().getItems().get(cellno);
//					getTableView().scrollTo(binTableRecord);
					
//					getTableView().getSelectionModel().setCellSelectionEnabled(true);
//					getTableView().requestFocus();
//					getTableView().getSelectionModel().select(cellrow, getTableColumn());
//				}
			}
		}
	};	
	
	private void win32PETreeTableShow() {
		
		/*
		 * データ初期化
		 */		
		//構造体サイズ
		IMAGE_DOS_HEADER_SIZE					= WORD*30+DWORD;
		IMAGE_FILE_HEADER_SIZE					= WORD*4+DWORD*3;
		IMAGE_DATA_DIRECTORY_SIZE				= DWORD*2;
		IMAGE_OPTIONAL_HEADER_SIZE				= BYTE*2+WORD*9+DWORD*19+IMAGE_DATA_DIRECTORY_SIZE*16; 	//PE32の場合
		IMAGE_NT_HEADER_SIZE					= DWORD + IMAGE_FILE_HEADER_SIZE + IMAGE_OPTIONAL_HEADER_SIZE;
		IMAGE_SECTION_HRADER_SIZE				= BYTE*IMAGE_SIZEOF_SHORT_NAME+WORD*2+DWORD*7;
		IMAGE_EXPORT_DIRECTORY_SIZE				= WORD*2+DWORD*9;
		IMAGE_IMPORT_DESCRIPTOR_SIZE			= DWORD*5;	
		PIMAGE_THUNK_DATA_SIZE					= DWORD;
		IMAGE_THUNK_DATA32_SIZE					= DWORD;
		IMAGE_THUNK_DATA64_SIZE					= ULONGLONG;
		IMAGE_RESOURCE_DIRECTORY_SIZE			= DWORD*2+WORD*4;
		RESOURCE_DIRECTORY_ENTRY_SIZE			= DWORD*2;
		RESOURCE_DATA_ENTRY_SIZE				= DWORD*4;
		IMAGE_ALPHA_RUNTIME_FUNCTION_ENTRY_SIZE	= DWORD*5;
		IMAGE_CE_RUNTIME_FUNCTION_ENTRY_SIZE	= DWORD*2;
		IMAGE_RUNTIME_FUNCTION_ENTRY_SIZE		= DWORD*3;
		IMAGE_ARMV7_RUNTIME_FUNCTION_ENTRY_SIZE	= DWORD*2;
		IMAGE_DEBUG_DIRECTRY_SIZE				= DWORD*6+WORD*2;
		PIMAGE_TLS_CALLBACK32_SIZE				= DWORD;
		PIMAGE_TLS_CALLBACK64_SIZE				= ULONGLONG;
		IMAGE_TLS_DIRECTORY32_SIZE				= DWORD*5+PIMAGE_TLS_CALLBACK32_SIZE;
		IMAGE_TLS_DIRECTORY64_SIZE				= DWORD*2+ULONGLONG*3+PIMAGE_TLS_CALLBACK64_SIZE;
		IMAGE_LOAD_CONFIG_DIRECTORY32_SIZE		= WORD*4+DWORD*16;
		IMAGE_LOAD_CONFIG_DIRECTORY64_SIZE		= WORD*4+DWORD*6+ULONGLONG*10;
		IMAGE_DELAY_IMPORT_DESCRIPTOR_SIZE		= DWORD*8;
		
		
		//先頭アドレス
		IMAGE_DOS_HEADER_START_ADDR						= "00000000";
		IMAGE_NT_HEADER_START_ADDR						= "";
		IMAGE_FILE_HEADER_START_ADDR					= "";
		IMAGE_OPTIONAL_HEADER_START_ADDR				= "";
		IMAGE_DIRECTORY_ENTRY_EXPORT_START_ADDR			= "";
		IMAGE_DIRECTORY_ENTRY_IMPORT_START_ADDR			= "";
		IMAGE_DIRECTORY_ENTRY_RESOURCE_START_ADDR		= "";
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_START_ADDR		= "";
		IMAGE_DIRECTORY_ENTRY_SECURITY_START_ADDR		= "";
		IMAGE_DIRECTORY_ENTRY_BASERELOC_START_ADDR		= "";
		IMAGE_DIRECTORY_ENTRY_DEBUG_START_ADDR			= "";
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_START_ADDR	= "";
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_START_ADDR		= "";
		IMAGE_DIRECTORY_ENTRY_TLS_START_ADDR			= "";
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_START_ADDR	= "";
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_START_ADDR	= "";
		IMAGE_DIRECTORY_ENTRY_IAT_START_ADDR			= "";
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_START_ADDR	= "";
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_START_ADDR	= "";
		IMAGE_SECTION_HEADER_START_ADDR					= "";
		
		//Item
		IMAGE_DIRECTORY_ENTRY_EXPORT_ITEM			= null;
		IMAGE_DIRECTORY_ENTRY_IMPORT_ITEM			= null;
		IMAGE_DIRECTORY_ENTRY_RESOURCE_ITEM			= null;
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_ITEM		= null;
		IMAGE_DIRECTORY_ENTRY_SECURITY_ITEM			= null;
		IMAGE_DIRECTORY_ENTRY_BASERELOC_ITEM		= null;
		IMAGE_DIRECTORY_ENTRY_DEBUG_ITEM			= null;
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_ITEM		= null;
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_ITEM		= null;
		IMAGE_DIRECTORY_ENTRY_TLS_ITEM				= null;
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_ITEM		= null;
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_ITEM		= null;
		IMAGE_DIRECTORY_ENTRY_IAT_ITEM				= null;
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_ITEM		= null;
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_ITEM	= null;
		
		//RVA、SIZE
		IMAGE_DIRECTORY_ENTRY_EXPORT_RVA			= "";
		IMAGE_DIRECTORY_ENTRY_IMPORT_RVA			= "";
		IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA			= "";
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA			= "";
		IMAGE_DIRECTORY_ENTRY_SECURITY_RVA			= "";
		IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA			= "";
		IMAGE_DIRECTORY_ENTRY_DEBUG_RVA				= "";
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_RVA		= "";
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_RVA			= "";
		IMAGE_DIRECTORY_ENTRY_TLS_RVA				= "";
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA		= "";
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_RVA		= "";
		IMAGE_DIRECTORY_ENTRY_IAT_RVA				= "";
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA		= "";
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_RVA	= "";
		
		IMAGE_DIRECTORY_ENTRY_EXPORT_RVA_SIZE			= 0;
		IMAGE_DIRECTORY_ENTRY_IMPORT_RVA_SIZE			= 0;
		IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA_SIZE			= 0;
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA_SIZE		= 0;
		IMAGE_DIRECTORY_ENTRY_SECURITY_RVA_SIZE			= 0;
		IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA_SIZE		= 0;
		IMAGE_DIRECTORY_ENTRY_DEBUG_RVA_SIZE			= 0;
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_RVA_SIZE		= 0;
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_RVA_SIZE		= 0;
		IMAGE_DIRECTORY_ENTRY_TLS_RVA_SIZE				= 0;
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA_SIZE		= 0;
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_RVA_SIZE		= 0;
		IMAGE_DIRECTORY_ENTRY_IAT_RVA_SIZE				= 0;
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA_SIZE		= 0;
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_RVA_SIZE	= 0;
		
		//
		IMAGE_SIZEOF_SHORT_NAME	= 8;
		
		//セクション数
		sectionCount	= 0;
		
		//セクション情報格納
		sectionList	= null;
		
		//残りデータ情報
		remainingDataRawAddr	= "00000000";
		reaminingDataRawSize		= 0;
		
		//Magic number
		magicNumber	= "";
		
		//ターゲットプラットフォーム
		targetPlatform	= "";
		
		//ハイライト用
		highlightStartAddr	= 0;
		highlightEndAddr	= 0;
		
		
		/*
		 * 作成
		 */
		//root作成
		root	= new TreeItem<>(new WinPE32TreeTableRecord(rootName, rootRaw, rootRVA, rootOffset, rootSize, rootValue, rootAnalysis, rootNotes));
		root.setExpanded(true);
		idWinPE32TreeTableView.setRoot(root);
			
		idWinPE32TreeTableColumnName.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("name"));
		idWinPE32TreeTableColumnCheck.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("check"));
//		idWinPE32TreeTableColumnCheck.setCellFactory(new Callback<TreeTableColumn<WinPE32TreeTableRecord, String>, TreeTableCell<WinPE32TreeTableRecord, String>>(){
//			@Override
//			public TreeTableCell<WinPE32TreeTableRecord, String> call(TreeTableColumn<WinPE32TreeTableRecord, String> p){
//				return new WinPE32TreeTableCell();
//			}
//		});	
		idWinPE32TreeTableColumnRaw.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("raw"));
		idWinPE32TreeTableColumnRVA.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("rva"));
		idWinPE32TreeTableColumnOffset.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("offset"));
		idWinPE32TreeTableColumnSize.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("size"));
		idWinPE32TreeTableColumnValue.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("value"));
		idWinPE32TreeTableColumnAnalysis.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("analysis"));
		idWinPE32TreeTableColumnNotes.setCellValueFactory(new TreeItemPropertyValueFactory<WinPE32TreeTableRecord, String>("notes"));

		idWinPE32TreeTableView.getColumns().set(0, idWinPE32TreeTableColumnName);
		idWinPE32TreeTableView.getColumns().set(1, idWinPE32TreeTableColumnCheck);
		idWinPE32TreeTableView.getColumns().set(2, idWinPE32TreeTableColumnRaw);
		idWinPE32TreeTableView.getColumns().set(3, idWinPE32TreeTableColumnRVA);
		idWinPE32TreeTableView.getColumns().set(4, idWinPE32TreeTableColumnOffset);
		idWinPE32TreeTableView.getColumns().set(5, idWinPE32TreeTableColumnSize);
		idWinPE32TreeTableView.getColumns().set(6, idWinPE32TreeTableColumnValue);
		idWinPE32TreeTableView.getColumns().set(7, idWinPE32TreeTableColumnAnalysis);
		idWinPE32TreeTableView.getColumns().set(8, idWinPE32TreeTableColumnNotes);		
		
		idWinPE32TreeTableView.expandedItemCountProperty();
		
		boolean	b	= false;
				
		try {
			/*
			 * IMAGE_DOS_HEADER
			 */
			b =	makeImageDosHeader(root, IMAGE_DOS_HEADER_START_ADDR); 

			if(!b) {
				idConsole.setText("It's not PE File format.");
				return;
			}
			
			/*
			 * IMAGE_NT_HEADERS
			 */
			makeImageNtHeader(root, IMAGE_NT_HEADER_START_ADDR);
					
			/*
			 * IMAGE_SECTION_HEADER
			 */
			makeImageSectionHeader(root, IMAGE_SECTION_HEADER_START_ADDR);
						
			/*
			 * IMAGE_EXPORT_DIRECTORY
			 */
			makeImageExportDirectory(IMAGE_DIRECTORY_ENTRY_EXPORT_ITEM);
			
			/*
			 * IMAGE_IMPORT_DESCRIPTOR
			 */
			makeImageImportDescriptor(IMAGE_DIRECTORY_ENTRY_IMPORT_ITEM);
			
			/*
			 * IMAGE_RESOURCE_DIRECTORY
			 */
			makeImageResourceDirectory(IMAGE_DIRECTORY_ENTRY_RESOURCE_ITEM);
			
			/*
			 * IMAGE_RUNTIME_FUNCTION_ENTRY
			 */
			makeImageRuntimeFunctionEntry(IMAGE_DIRECTORY_ENTRY_EXCEPTION_ITEM);
			
			/*
			 * ATTRIBUTE_CERTIFICATE_ENTRY
			 */
			makeAttributeCertificateEntry(IMAGE_DIRECTORY_ENTRY_SECURITY_ITEM);
			
			/*
			 * IMAGE_BASE_RELOCATION
			 */
			makeImageBaseRelocation(IMAGE_DIRECTORY_ENTRY_BASERELOC_ITEM);
			
			/*
			 * IMAGE_DEBUG_DIRECTORY
			 */
			makeImageDebugDirectoty(IMAGE_DIRECTORY_ENTRY_DEBUG_ITEM);
			
			/*
			 * IMAGE_TLS_DIRECTORY
			 */
			makeImageTlsDirectory(IMAGE_DIRECTORY_ENTRY_TLS_ITEM);
			
			/*
			 * IMAGE_LOAD_CONFIG_DIRECTORY
			 */
			makeImageLoadConfigDirectory(IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_ITEM);
			
			/*
			 * IMPORT_ADDRESS_TABLE
			 */
			makeImportAddressTable(IMAGE_DIRECTORY_ENTRY_IAT_ITEM);
			
			/*
			 * IMAGE_DELAY_IMPORT_DESCRIPTOR
			 */
			makeImageDelayImportDescriptor(IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_ITEM);
			
			
		}catch(Exception e) {
			
//			try{
//				StringWriter sw	= new StringWriter();
//				e.printStackTrace(new PrintWriter(sw));	
//				File errorFile			= new File("error.txt");
//				FileWriter fileWriter	= new FileWriter(errorFile);
//				fileWriter.write(sw.toString());
//				fileWriter.close();
//			}catch(Exception e2) {
//				e.printStackTrace();
//			}
			
			String message	= "An error occured.";	
//			message.concat("Please look at the error file(error.txt).");
			idConsole.setText(message);
			
			String alertType				= "ERROR";
			String title					= "ERROR";
			String headerText				= "ERROR";
			String contentText				= "An error occured.";
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String expandableContentText	= sw.toString();
			
			alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
				
		}
		
	}
	
	
	public class WinPE32TreeTableCell extends TreeTableCell<WinPE32TreeTableRecord, String> {
		
		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);

			//int cellno		= getIndex();
			//int cellcolumn	= cellno % getTreeTableView().getColumns().size();
			
			if(item != null) {
				if(getTreeTableRow().getItem() != null){			
					if(getTreeTableRow().getItem().getCheck().equals("*")){
						setText(item.toString());
						getStyleClass().clear();
						getStyleClass().add("winpe32-tree-table-check-hignligt");
					}else{
						setText(item.toString());
						getStyleClass().clear();
						getStyleClass().add("winpe32-tree-table-check");
					}
				}
			}
		}
	}
	
	
	private boolean makeImageDosHeader(TreeItem<WinPE32TreeTableRecord> root, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DOS_HEADER_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		String notes	= "";
		
		//IMAGE_DOS_HEADER
		name		= "IMAGE_DOS_HEADER";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DOS_HEADER_SIZE;
		value		= "";
		analysis 	= "";
		notes		= IMAGE_DOS_HEADERNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DOS_HEADER					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DOS_HEADERItem 	= new TreeItem<>(IMAGE_DOS_HEADER);
//		IMAGE_DOS_HEADERItem.setExpanded(true);
		
		//0x00	WORD	e_magic
		name	= "e_magic";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		for(int i=offset; i<offset+size; i++){
			analysis	+= String.format("%c", data[i]);
		}
		notes	= e_magicNotes;
		beforesize	= size;
		
		if(!analysis.equals("MZ")) {
			return false;
		}
		
		WinPE32TreeTableRecord e_magic					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_magicItem	= new TreeItem<>(e_magic);
//		e_magicItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_magicItem);
		
		
		//0x02	WORD	e_cblp;
		name	= "e_cblp";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_cblpNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_cblp				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_cblpItem	= new TreeItem<>(e_cblp);
//		e_cblpItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_cblpItem);

		
		//0x04	WORD	e_cp;
		name	= "e_cp";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_cpNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_cp					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_cpItem	= new TreeItem<>(e_cp);
//		e_cpItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_cpItem);
		
		
		//0x06	WORD	e_crlc;
		name	= "e_crlc";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_crlcNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_crlc				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_crlcItem	= new TreeItem<>(e_crlc);
//		e_crlcItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_crlcItem);
		
		
		//0x08	WORD	e_charhdr;
		name	= "e_charhdr";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_charhdrNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_charhdr				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_charhdrItem	= new TreeItem<>(e_charhdr);
//		e_charhdrItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_charhdrItem);
		
		
		//0x0a	WORD	e_minalloc;
		name	= "e_minalloc";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_minallocNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_minalloc				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_minallocItem	= new TreeItem<>(e_minalloc);
//		e_minallocItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_minallocItem);
		
		
		//0x0c	WORD	e_maxalloc;
		name	= "e_maxalloc";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_maxallocNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_maxalloc				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_maxallocItem	= new TreeItem<>(e_maxalloc);
//		e_maxallocItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_maxallocItem);
		
		
		//0x0e	WORD	e_ss;
		name	= "e_ss";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_ssNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_ss					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_ssItem	= new TreeItem<>(e_ss);
//		e_ssItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_ssItem);
		
		
		//0x10	WORD	e_sp;
		name	= "e_sp";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_spNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_sp					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_spItem	= new TreeItem<>(e_sp);
//		e_spItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_spItem);
		
		
		//0x12	WORD	e_csum 
		name	= "e_csum";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_csumNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_csum				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_csumItem	= new TreeItem<>(e_csum);
//		e_csumItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_csumItem);
		
		
		//0x14	WORD	e_ip 
		name	= "e_ip";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_ipNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_ip					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_ipItem	= new TreeItem<>(e_ip);
//		e_ipItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_ipItem);	
		
			
		//0x16	WORD	e_cs 
		name	= "e_cs";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_csNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_cs					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_csItem	= new TreeItem<>(e_cs);
//		e_csItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_csItem);	
		
		
		//0x18	WORD	e_lfarlc 
		name	= "e_lfarlc";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_lfarlcNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_lfarlc					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_lfarlcItem	= new TreeItem<>(e_lfarlc);
//		e_lfarlcItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_lfarlcItem);	
		
		
		//0x1a	WORD	e_ovno 
		name	= "e_ovno";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_ovnoNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_ovno					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_ovnoItem	= new TreeItem<>(e_ovno);
//		e_ovnoItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_ovnoItem);	
		
		
		//0x1c	WORD	e_res[4]
		name	= "e_res[4]";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD*4;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_resNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_res				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_resItem	= new TreeItem<>(e_res);
//		e_resItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_resItem);	
		
		
		//0x24	WORD	e_oemid 
		name	= "e_oemid";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_oemidNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_oemid				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_oemidItem	= new TreeItem<>(e_oemid);
//		e_oemidItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_oemidItem);	
		
		
		//0x26	WORD	e_oeminfo
		name	= "e_oeminfo";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_oeminfoNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_oeminfo				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_oeminfoItem	= new TreeItem<>(e_oeminfo);
//		e_oeminfoItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_oeminfoItem);
		
		
		//0x28	WORD	e_res2[10]
		name	= "e_res2[10]";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD*10;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_res2Notes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_res2				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_res2Item	= new TreeItem<>(e_res2);
//		e_res2Item.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_res2Item);	
		
		
		//0x3c	DWORD	e_lfanew	
		name	= "e_lfanew";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= e_lfanewNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord e_lfanew					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> e_lfanewItem	= new TreeItem<>(e_lfanew);
//		e_lfanewItem.setExpanded(true);
		IMAGE_DOS_HEADERItem.getChildren().add(e_lfanewItem);
		
		//IMAGE_NT_HEADERアドレス格納
		IMAGE_NT_HEADER_START_ADDR	= getAddStrAddr(IMAGE_DOS_HEADER_START_ADDR, false, value, false);
		
		root.getChildren().add(IMAGE_DOS_HEADERItem);
		
		return true;
		
	}
	
	private void makeImageNtHeader(TreeItem<WinPE32TreeTableRecord> root, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_NT_HEADER_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		String notes	= "";
		
		//IMAGE_NT_HEADER
		name		= "IMAGE_NT_HEADER";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_NT_HEADER_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_NT_HEADERNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_NT_HEADER					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_NT_HEADERItem 	= new TreeItem<>(IMAGE_NT_HEADER);
//		IMAGE_NT_HEADERItem.setExpanded(true);
		root.getChildren().add(IMAGE_NT_HEADERItem);
		
		
		//0x00	DWORD	Signature
		name	= "Signature";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		for(int i=offset; i<offset+size; i++){
			analysis	+= String.format("%c", data[i]);
		}
		notes		= SignatureNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord Signature				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SignatureItem	= new TreeItem<>(Signature);
//		SignatureItem.setExpanded(true);
		IMAGE_NT_HEADERItem.getChildren().add(SignatureItem);
		
		
		//0x04	IMAGE_FILE_HEADER	FileHeader
		name		= "FileHeader";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= offset + beforesize;
		size		= IMAGE_FILE_HEADER_SIZE;
		value		= "";
//		for(int i=offset+size-1; i>=offset; i-- ){
//			value	+= String.format("%02X", data[i]).toUpperCase();
//		}
		analysis	= "";
		notes		= IMAGE_FILE_HEADERNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord FileHeader				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> FileHeaderItem	= new TreeItem<>(FileHeader);
//		FileHeaderItem.setExpanded(true);
		IMAGE_NT_HEADERItem.getChildren().add(FileHeaderItem);
		
		//IMAGE_FILE_HEADER作成
		IMAGE_FILE_HEADER_START_ADDR	= String.format("%08X", rawAddr);
		makeImageFileHeader(FileHeaderItem, IMAGE_FILE_HEADER_START_ADDR);
		
		
		//0x18	IMAGE_OPTIONAL_HEADER	OptionalHeader
		name		= "OptionalHeader";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= offset + beforesize;
		size		= IMAGE_OPTIONAL_HEADER_SIZE;
		value		= "";
//		for(int i=offset+size-1; i>=offset; i-- ){
//			value	+= String.format("%02X", data[i]).toUpperCase();
//		}
		analysis	= "";
		notes		= IMAGE_OPTIONAL_HEADERNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord OptionalHeader				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> OptionalHeaderItem	= new TreeItem<>(OptionalHeader);
//		OptionalHeaderItem.setExpanded(true);
		IMAGE_NT_HEADERItem.getChildren().add(OptionalHeaderItem);
		
		//IMAGE_OPTIONAL_HEADER作成
		IMAGE_OPTIONAL_HEADER_START_ADDR	= String.format("%08X", rawAddr);
		makeImageOptionalHeader(OptionalHeaderItem, IMAGE_OPTIONAL_HEADER_START_ADDR);
		
		//PE32+の場合IMAGE_OPTIONAL_HEADER_SIZEが違うため、IMAGE_NT_HEADER_SIZE更新
		IMAGE_NT_HEADER_SIZE = 0x04 + IMAGE_FILE_HEADER_SIZE + IMAGE_OPTIONAL_HEADER_SIZE;
		IMAGE_NT_HEADERItem.getValue().setSize(String.format("%08X", IMAGE_NT_HEADER_SIZE));
		
		
	}

	private void makeImageFileHeader(TreeItem<WinPE32TreeTableRecord> IMAGE_FILE_HEADERItem, String strStartAddr) {
				
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_FILE_HEADER_SIZE;		
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";	
		
		//0x00	DWORD	Machine
		name	= "Machine";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		if(value.equals("0000")) {
			analysis	= "IMAGE_FILE_MACHINE_UNKNOWN(0x0000): The contents of this field are assumed to be applicable to any machine type.";
		}else if(value.equals("01D3")) {
			analysis	= "IMAGE_FILE_MACHINE_AM33(0x01D3): Matsushita AM33";
		}else if(value.equals("8664")) {
			analysis	= "IMAGE_FILE_MACHINE_AMD64(0x8664): x64";
		}else if(value.equals("01C0")) {
			analysis	= "IMAGE_FILE_MACHINE_ARM(0x01C0): ARM little endian";
		}else if(value.equals("01C4")) {
			analysis	= "IMAGE_FILE_MACHINE_ARMNT(0x01C4): ARMv7 (or higher) Thumb mode only";
		}else if(value.equals("AA64")) {
			analysis	= "IMAGE_FILE_MACHINE_ARM64(0xAA64): ARMv8 in 64-bit mode";
		}else if(value.equals("0EBC")) {
			analysis	= "IMAGE_FILE_MACHINE_EBC(0x0EBC): EFI byte code";
		}else if(value.equals("014C")){
			analysis	= "IMAGE_FILE_MACHINE_I386(0x014C): Intel 386 or later processors and compatible processors";
		}else if(value.equals("0200")) {
			analysis	= "IMAGE_FILE_MACHINE_IA64(0x0200): Intel Itanium processor family";
		}else if(value.equals("9041")) {
			analysis	= "IMAGE_FILE_MACHINE_M32R(0x9041): Mitsubishi M32R little endian";
		}else if(value.equals("0266")) {
			analysis	= "IMAGE_FILE_MACHINE_MIPS16(0x0266): MIPS16";
		}else if(value.equals("0366")) {
			analysis	= "IMAGE_FILE_MACHINE_MIPSFPU(0x0366): MIPS with FPU";
		}else if(value.equals("0466")) {
			analysis	= "IMAGE_FILE_MACHINE_MIPSFPU16(0x0466): MIPS16 with FPU";
		}else if(value.equals("01F0")) {
			analysis	= "IMAGE_FILE_MACHINE_POWERPC(0x01F0): Power PC little endian";
		}else if(value.equals("01F1")) {
			analysis	= "IMAGE_FILE_MACHINE_POWERPCFP(0x01F1): Power PC with floating point support";
		}else if(value.equals("0166")) {
			analysis	= "IMAGE_FILE_MACHINE_R4000(0x0166): MIPS little endian";
		}else if(value.equals("01A2")) {
			analysis	= "IMAGE_FILE_MACHINE_SH3(0x01A2): Hitachi SH3";
		}else if(value.equals("01A3")) {
			analysis	= "IMAGE_FILE_MACHINE_SH3DSP(0x01A3): Hitachi SH3 DSP";
		}else if(value.equals("01A6")) {
			analysis	= "IMAGE_FILE_MACHINE_SH4(0x01A6): Hitachi SH4";
		}else if(value.equals("01A8")) {
			analysis	= "IMAGE_FILE_MACHINE_SH5(0x01A8): Hitachi SH5";
		}else if(value.equals("01C2")) {
			analysis	= "IMAGE_FILE_MACHINE_THUMB(0x01C2): ARM or Thumb (\"interworking\")";
		}else if(value.equals("0169")) {
			analysis	= "IMAGE_FILE_MACHINE_WCEMIPSV2(0x0169): MIPS little-endian WCE v2";
		}
		notes		= MachineNotes;
		beforesize	= size;
		
		//ターゲットプラットフォーム
		targetPlatform	= value;
		
		WinPE32TreeTableRecord Machine					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MachineItem	= new TreeItem<>(Machine);
//		MachineItem.setExpanded(true);
		IMAGE_FILE_HEADERItem.getChildren().add(MachineItem);

		
		//0x02	WORD	NumberOfSections
		name	= "NumberOfSections";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= NumberOfSectionsNotes;
		beforesize	= size;
		
		//セクション数格納
		sectionCount	= getStringToInt(value, false);
		
		WinPE32TreeTableRecord NumberOfSections					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> NumberOfSectionsItem	= new TreeItem<>(NumberOfSections);
//		NumberOfSectionsItem.setExpanded(true);
		IMAGE_FILE_HEADERItem.getChildren().add(NumberOfSectionsItem);

		
		//0x04	DWORD	TimeDataStamp
		name	= "TimeDataStamp";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		Date date = new Date(Long.parseLong(value, 16)*1000);
		analysis	= date.toString();		
		notes		= TimeDataStampNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord TimeDataStamp				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> TimeDataStampItem	= new TreeItem<>(TimeDataStamp);
//		TimeDataStampItem.setExpanded(true);
		IMAGE_FILE_HEADERItem.getChildren().add(TimeDataStampItem);
		
		
		//0x08	DWORD	PointerToSymbolTable
		name	= "PointerToSymbolTable";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= PointerToSymbolTableNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord PointerToSymbolTable				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> PointerToSymbolTableItem	= new TreeItem<>(PointerToSymbolTable);
//		PointerToSymbolTableItem.setExpanded(true);
		IMAGE_FILE_HEADERItem.getChildren().add(PointerToSymbolTableItem);
		
		
		//0x0c	DWORD	NumberOfSymbols
		name	= "NumberOfSymbols";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= NumberOfSymbolsNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord NumberOfSymbols				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> NumberOfSymbolsItem	= new TreeItem<>(NumberOfSymbols);
//		NumberOfSymbolsItem.setExpanded(true);
		IMAGE_FILE_HEADERItem.getChildren().add(NumberOfSymbolsItem);
		
		
		//0x10	WORD	SizeOfOptionalHeader
		name	= "SizeOfOptionalHeader";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= SizeOfOptionalHeaderNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord SizeOfOptionalHeader					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeOfOptionalHeaderItem	= new TreeItem<>(SizeOfOptionalHeader);
//		SizeOfOptionalHeaderItem.setExpanded(true);
		IMAGE_FILE_HEADERItem.getChildren().add(SizeOfOptionalHeaderItem);
		
		//OPTIONAL_HEADERサイズ格納
		IMAGE_OPTIONAL_HEADER_SIZE	= getStringToInt(value, false);
		
		
		//0x12	WORD	Characteristics
		name	= "Characteristics";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		if((v & 0x0001)>0) {
			analysis	+= "IMAGE_FILE_RELOCS_STRIPPED(0x0001)\n";
		}
		if((v & 0x0002)>0) {
			analysis	+= "IMAGE_FILE_EXECUTABLE_IMAGE(0x0002)\n";
		}
		if((v & 0x0004)>0) {
			analysis	+= "IMAGE_FILE_LINE_NUMS_STRIPPED(0x0004)\n";
		}
		if((v & 0x0008)>0) {
			analysis	+= "IMAGE_FILE_LOCAL_SYMS_STRIPPED(0x0008)\n";
		}
		if((v & 0x0010)>0) {
			analysis	+= "IMAGE_FILE_AGGRESSIVE_WS_TRIM(0x0010)\n";
		}
		if((v & 0x0020)>0) {
			analysis	+= "IMAGE_FILE_LARGE_ADDRESS_AWARE(0x0020)\n";
		}
		if((v & 0x0080)>0) {
			analysis	+= "IMAGE_FILE_BYTES_REVERSED_LO(0x0080)\n";
		}
		if((v & 0x0100)>0) {
			analysis	+= "IMAGE_FILE_32BIT_MACHINE(0x0100)\n";
		}
		if((v & 0x0200)>0) {
			analysis	+= "IMAGE_FILE_DEBUG_STRIPPED(0x0200)\n";
		}
		if((v & 0x0400)>0) {
			analysis	+= "IMAGE_FILE_REMOVABLE_RUN_FROM_SWAP(0x0400)\n";
		}
		if((v & 0x0800)>0) {
			analysis	+= "IMAGE_FILE_NET_RUN_FROM_SWAP(0x0800)\n";
		}
		if((v & 0x1000)>0) {
			analysis	+= "IMAGE_FILE_SYSTEM(0x1000)\n";
		}
		if((v & 0x2000)>0) {
			analysis	+= "IMAGE_FILE_DLL(0x2000)\n";
		}
		if((v & 0x4000)>0) {
			analysis	+= "IMAGE_FILE_UP_SYSTEM_ONLY(0x4000)\n";
		}
		if((v & 0x8000)>0) {
			analysis	+= "IMAGE_FILE_BYTES_REVERSED_HI(0x8000)\n";
		}		
		notes		= CharacteristicsNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord Characteristics				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//		CharacteristicsItem.setExpanded(true);
		IMAGE_FILE_HEADERItem.getChildren().add(CharacteristicsItem);
		
	}
	
	private void makeImageOptionalHeader(TreeItem<WinPE32TreeTableRecord> IMAGE_OPTIONAL_HEADERItem, String strStartAddr) {
				
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);

		//データ取得
		int dataSize	= IMAGE_OPTIONAL_HEADER_SIZE;		
		byte[] data		= getBintableBytes(startAddr, dataSize);

		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long lv			= 0;
		String notes	= "";

		/*
		 * Standard fields		
		 */
		
		//0x00	WORD	Magic
		name	= "Magic";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		if(value.equals("010B")) {
			analysis	= "PE32";
		}else if(value.equals("020B")) {
			analysis	= "PE32+";
		}
		notes		= MagicNotes;
		beforesize	= size;
		magicNumber	= value;

		WinPE32TreeTableRecord Magic				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MagicItem	= new TreeItem<>(Magic);
		//MagicItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MagicItem);		
		
		
		//0x02	BYTE	MajorLinkerVersion
		name	= "MajorLinkerVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= BYTE;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= MajorLinkerVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MajorLinkerVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MajorLinkerVersionItem	= new TreeItem<>(MajorLinkerVersion);
		//MajorLinkerVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MajorLinkerVersionItem);	
		
		
		//0x03	BYTE	MinorLinkerVersion
		name	= "MinorLinkerVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= BYTE;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= MinorLinkerVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MinorLinkerVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MinorLinkerVersionItem	= new TreeItem<>(MinorLinkerVersion);
		//MajorLinkerVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MinorLinkerVersionItem);
		
		
		//0x04	DWORD	SizeOfCode
		name	= "SizeOfCode";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v)+" bytes";
		notes		= SizeOfCodeNotes;
		beforesize	= size;

		WinPE32TreeTableRecord SizeOfCode				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeOfCodeItem	= new TreeItem<>(SizeOfCode);
		//SizeOfCodeItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfCodeItem);
		
		
		//0x08	DWORD	SizeOfInitializedData
		name	= "SizeOfInitializedData";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v)+" bytes";
		notes		= SizeOfInitializedDataNotes;
		beforesize	= size;

		WinPE32TreeTableRecord SizeOfInitializedData				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeOfInitializedDataItem	= new TreeItem<>(SizeOfInitializedData);
		//SizeOfInitializedDataItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfInitializedDataItem);		
		
		
		//0x0c	DWORD	SizeOfUninitializedData
		name	= "SizeOfUninitializedData";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v)+" bytes";
		notes		= SizeOfUninitializedDataNotes;
		beforesize	= size;

		WinPE32TreeTableRecord SizeOfUninitializedData					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeOfUninitializedDataItem	= new TreeItem<>(SizeOfUninitializedData);
		//SizeOfUninitializedDataItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfUninitializedDataItem);		
		
		
		//0x10	DWORD	AddressOfEntryPoint
		name	= "AddressOfEntryPoint";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= AddressOfEntryPointNotes;
		beforesize	= size;

		WinPE32TreeTableRecord AddressOfEntryPoint					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> AddressOfEntryPointItem	= new TreeItem<>(AddressOfEntryPoint);
		//SAddressOfEntryPointItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(AddressOfEntryPointItem);		
		
		
		//0x14	DWORD	BaseOfCode
		name	= "BaseOfCode";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= BaseOfCodeNotes;
		beforesize	= size;

		WinPE32TreeTableRecord BaseOfCode				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> BaseOfCodeItem	= new TreeItem<>(BaseOfCode);
		//BaseOfCodeItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(BaseOfCodeItem);		
					

 		//PE32 contains BaseOfData, which is absent in PE32+, following BaseOfCode.
		if(magicNumber.equals("010B")) {	//PE32
			
			//0x18	DWORD	BaseOfData
			name	= "BaseOfData";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= BaseOfDataNotes;
			beforesize	= size;

			WinPE32TreeTableRecord BaseOfData				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> BaseOfDataItem	= new TreeItem<>(BaseOfData);
			//BaseOfDataItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(BaseOfDataItem);	
		}
		
		
		/*
		 * Windows specific fields
		 */
		if(magicNumber.equals("010B")) {	//PE32	
		
			//0x1c	DWORD	ImageBase
			name	= "ImageBase";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= ImageBaseNotes;
			beforesize	= size;

			WinPE32TreeTableRecord ImageBase				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> ImageBaseItem	= new TreeItem<>(ImageBase);
			//ImageBaseItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(ImageBaseItem);		
			
		}else if(magicNumber.equals("020B")){	//PE32+
			
			//0x18	ULONGLONG	ImageBase
			name	= "ImageBase";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ULONGLONG;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= ImageBaseNotes;
			beforesize	= size;

			WinPE32TreeTableRecord ImageBase				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> ImageBaseItem	= new TreeItem<>(ImageBase);
			//ImageBaseItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(ImageBaseItem);	
			
		}
			
			
		//0x20	DWORD	SectionAlignment
		name	= "SectionAlignment";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= SectionAlignmentNotes;
		beforesize	= size;

		WinPE32TreeTableRecord SectionAlignment					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SectionAlignmentItem	= new TreeItem<>(SectionAlignment);
		//SectionAlignmentItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(SectionAlignmentItem);			
		
		
		//0x24	DWORD	FileAlignment
		name	= "FileAlignment";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= FileAlignmentNotes;
		beforesize	= size;

		WinPE32TreeTableRecord FileAlignment				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> FileAlignmentItem	= new TreeItem<>(FileAlignment);
		//FileAlignmentItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(FileAlignmentItem);			
	
	
		//0x28	WORD	MajorOperatingSystemVersion
		name	= "MajorOperatingSystemVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		notes		= MajorOperatingSystemVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MajorOperatingSystemVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MajorOperatingSystemVersionItem	= new TreeItem<>(MajorOperatingSystemVersion);
		//MajorOperatingSystemVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MajorOperatingSystemVersionItem);	
	
	
		//0x2a	WORD	MinorOperatingSystemVersion
		name	= "MinorOperatingSystemVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		notes		= MinorOperatingSystemVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MinorOperatingSystemVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MinorOperatingSystemVersionItem	= new TreeItem<>(MinorOperatingSystemVersion);
		//MinorOperatingSystemVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MinorOperatingSystemVersionItem);	
		
	
		//0x2c	WORD	MajorImageVersion
		name	= "MajorImageVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		notes		= MajorImageVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MajorImageVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MajorImageVersionItem	= new TreeItem<>(MajorImageVersion);
		//MajorImageVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MajorImageVersionItem);	
	
	
		//0x2e	WORD	MinorImageVersion
		name	= "MinorImageVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		notes		= MinorImageVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MinorImageVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MinorImageVersionItem	= new TreeItem<>(MinorImageVersion);
		//MinorImageVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MinorImageVersionItem);
		
	
		//0x30	WORD	MajorSubSystemVersion
		name	= "MajorSubSystemVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		notes		= MajorSubSystemVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MajorSubSystemVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MajorSubSystemVersionItem	= new TreeItem<>(MajorSubSystemVersion);
		//MajorSubSystemVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MajorSubSystemVersionItem);
	
	
		//0x32	WORD	MinorSubSystemVersion
		name	= "MinorSubSystemVersion";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		notes		= MinorSubSystemVersionNotes;
		beforesize	= size;

		WinPE32TreeTableRecord MinorSubSystemVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> MinorSubSystemVersionItem	= new TreeItem<>(MinorSubSystemVersion);
		//MinorSubSystemVersionItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(MinorSubSystemVersionItem);	
	
		
		//0x34	DWORD	Win32VersionValue
		name	= "Win32VersionValue";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= Win32VersionValueNotes;
		beforesize	= size;

		WinPE32TreeTableRecord Win32VersionValue				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> Win32VersionValueItem	= new TreeItem<>(Win32VersionValue);
		//Win32VersionValueItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(Win32VersionValueItem);	
		
		
		//0x38	DWORD	SizeOfImage
		name	= "SizeOfImage";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= SizeOfImageNotes;
		beforesize	= size;

		WinPE32TreeTableRecord SizeOfImage					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeOfImageItem	= new TreeItem<>(SizeOfImage);
		//SizeOfImageItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfImageItem);	
		
		
		//0x3c	DWORD	SizeOfHeaders
		name	= "SizeOfHeaders";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		analysis	= "";
		notes		= SizeOfHeadersNotes;
		beforesize	= size;

		WinPE32TreeTableRecord SizeOfHeaders				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeOfHeadersItem	= new TreeItem<>(SizeOfHeaders);
		//SizeOfHeadersItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfHeadersItem);	
		
		
		//0x40	DWORD	CheckSum
		name	= "CheckSum";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= CheckSumNotes;
		beforesize	= size;

		WinPE32TreeTableRecord CheckSum				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> CheckSumItem	= new TreeItem<>(CheckSum);
		//CheckSumItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(CheckSumItem);	
		
	
		//0x44	WORD	Subsystem
		name	= "Subsystem";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		if(v == 0) {
			analysis	= "IMAGE_SUBSYSTEM_UNKNOWN(0): An unknown subsystem";
		}else if (v == 1) {
			analysis	= "IMAGE_SUBSYSTEM_NATIVE(1): Device drivers and native Windows process";
		}else if (v == 2) {
			analysis	= "IMAGE_SUBSYSTEM_WINDOWS_GUI(2): The Windows graphical user interface (GUI) subsystem";
		}else if (v == 3) {
			analysis	= "IMAGE_SUBSYSTEM_WINDOWS_CUI(3): The Windows character subsystem";
		}else if (v == 7) {
			analysis	= "IMAGE_SUBSYSTEM_POSIX_CUI(7): The Posix character subsystem";
		}else if (v == 9) {
			analysis	= "IMAGE_SUBSYSTEM_WINDOWS_CE_GUI(9): Windows CE";
		}else if (v == 10) {
			analysis	= "IMAGE_SUBSYSTEM_EFI_APPLICATION(10): An Extensible Firmware Interface (EFI) application";
		}else if (v == 11) {
			analysis	= "IMAGE_SUBSYSTEM_EFI_BOOT_ SERVICE_DRIVER(11): An EFI driver with boot services";
		}else if (v == 12) {
			analysis	= "IMAGE_SUBSYSTEM_EFI_RUNTIME_DRIVER(12): An EFI driver with run-time services";
		}else if (v == 13) {
			analysis	= "IMAGE_SUBSYSTEM_EFI_ROM(13): An EFI ROM image";
		}else if (v == 14) {
			analysis	= "IMAGE_SUBSYSTEM_XBOX(14): XBOX";
		}
		notes		= SubsystemNotes;
		beforesize	= size;

		WinPE32TreeTableRecord Subsystem				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SubsystemItem	= new TreeItem<>(Subsystem);
		//SubsystemItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(SubsystemItem);	

		
		//0x46	WORD	DllCharacteristics
		name	= "DllCharacteristics";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		if((v & 0x0040)>0) {
			analysis	+= "IMAGE_DLL_CHARACTERISTICS_DYNAMIC_BASE(0x0040)\n";
		}else if((v & 0x0080)>0) {
			analysis	+= "IMAGE_DLL_CHARACTERISTICS_FORCE_INTEGRITY(0x0080)\n";
		}else if((v & 0x0100)>0) {
			analysis	+= "IMAGE_DLL_CHARACTERISTICS_NX_COMPAT(0x0100)\n";
		}else if((v & 0x0200)>0) {
			analysis	+= "IMAGE_DLLCHARACTERISTICS_NO_ISOLATION(0x0200)\n";
		}else if((v & 0x0400)>0) {
			analysis	+= "IMAGE_DLLCHARACTERISTICS_NO_SEH(0x0400)\n";
		}else if((v & 0x0800)>0) {
			analysis	+= "IMAGE_DLLCHARACTERISTICS_NO_BIND(0x0800)\n";
		}else if((v & 0x2000)>0) {
			analysis	+= "IMAGE_DLLCHARACTERISTICS_WDM_DRIVER(0x2000)\n";
		}else if((v & 0x8000)>0) {
			analysis	+= "IMAGE_DLLCHARACTERISTICS_TERMINAL_SERVER_AWARE(0x8000)\n";
		}
		notes		= DllCharacteristicsNotes;
		beforesize	= size;

		WinPE32TreeTableRecord DllCharacteristics				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> DllCharacteristicsItem	= new TreeItem<>(DllCharacteristics);
		//DllCharacteristicsItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(DllCharacteristicsItem);	
		

		if(magicNumber.equals("010B")) {	//PE32	

			//0x48	DWORD	SizeOfStackReserve
			name	= "SizeOfStackReserve";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= SizeOfStackReserveNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfStackReserve				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfStackReserveItem	= new TreeItem<>(SizeOfStackReserve);
			//SizeOfStackReserveItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfStackReserveItem);
		
		
			//0x4c	DWORD	SizeOfStackCommit
			name	= "SizeOfStackCommit";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= SizeOfStackCommitNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfStackCommit				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfStackCommitItem	= new TreeItem<>(SizeOfStackCommit);
			//SizeOfStackCommitItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfStackCommitItem);	
	

			//0x50	DWORD	SizeOfHeapReserve
			name	= "SizeOfHeapReserve";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= SizeOfHeapReserveNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfHeapReserve				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfHeapReserveItem	= new TreeItem<>(SizeOfHeapReserve);
			//SizeOfHeapReserveItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfHeapReserveItem);	
			
		
			//0x54	DWORD	SizeOfHeapCommit
			name	= "SizeOfHeapCommit";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= SizeOfHeapCommitNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfHeapCommit				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfHeapCommitItem	= new TreeItem<>(SizeOfHeapCommit);
			//SizeOfHeapCommitItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfHeapCommitItem);	
		

		}else if(magicNumber.equals("020B")){	//PE32+
			
			//0x48	ULONGLONG	SizeOfStackReserve
			name	= "SizeOfStackReserve";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ULONGLONG;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			lv			= getStringToLong(value, false);
			analysis	= String.valueOf(lv)+" bytes";
			notes		= SizeOfStackReserveNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfStackReserve				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfStackReserveItem	= new TreeItem<>(SizeOfStackReserve);
			//SizeOfStackReserveItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfStackReserveItem);
		
		
			//0x50	ULONGLONG	SizeOfStackCommit
			name	= "SizeOfStackCommit";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ULONGLONG;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			lv			= getStringToLong(value, false);
			analysis	= String.valueOf(lv)+" bytes";
			notes		= SizeOfStackCommitNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfStackCommit				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfStackCommitItem	= new TreeItem<>(SizeOfStackCommit);
			//SizeOfStackCommitItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfStackCommitItem);	
	

			//0x58	ULONGLONG	SizeOfHeapReserve
			name	= "SizeOfHeapReserve";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ULONGLONG;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			lv			= getStringToLong(value, false);
			analysis	= String.valueOf(lv)+" bytes";
			notes		= SizeOfHeapReserveNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfHeapReserve				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfHeapReserveItem	= new TreeItem<>(SizeOfHeapReserve);
			//SizeOfHeapReserveItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfHeapReserveItem);	
			
		
			//0x60	ULONGLONG	SizeOfHeapCommit
			name	= "SizeOfHeapCommit";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= ULONGLONG;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			lv			= getStringToLong(value, false);
			analysis	= String.valueOf(lv)+" bytes";
			notes		= SizeOfHeapCommitNotes;
			beforesize	= size;

			WinPE32TreeTableRecord SizeOfHeapCommit				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfHeapCommitItem	= new TreeItem<>(SizeOfHeapCommit);
			//SizeOfHeapCommitItem.setExpanded(true);
			IMAGE_OPTIONAL_HEADERItem.getChildren().add(SizeOfHeapCommitItem);	

			
		}
		
		//0x58/0x68	DWORD	LoaderFlags
		name	= "LoaderFlags";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= LoaderFlagsNotes;
		beforesize	= size;

		WinPE32TreeTableRecord LoaderFlags				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> LoaderFlagsItem	= new TreeItem<>(LoaderFlags);
		//LoaderFlagsItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(LoaderFlagsItem);	
	
	
		//0x5c/0x6c	DWORD	NumberOfRvaAndSizes
		name	= "NumberOfRvaAndSizes";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v);
		notes		= NumberOfRvaAndSizesNotes;
		beforesize	= size;

		WinPE32TreeTableRecord NumberOfRvaAndSizes					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> NumberOfRvaAndSizesItem	= new TreeItem<>(NumberOfRvaAndSizes);
		//NumberOfRvaAndSizesItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(NumberOfRvaAndSizesItem);	
			
		
		/*
		 * Data directories
		 */
		//0x60/0x70	IMAGE_DATA_DIRECTORY	DataDirectory[16]
		name	= "DataDirectory[16]";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= IMAGE_DATA_DIRECTORY_SIZE*16;
		value	= "";
		analysis	= "";
		notes		= DataDirectoryNotes;
		beforesize	= size;

		WinPE32TreeTableRecord DataDirectory				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> DataDirectoryItem	= new TreeItem<>(DataDirectory);
		//DataDirectoryItem.setExpanded(true);
		IMAGE_OPTIONAL_HEADERItem.getChildren().add(DataDirectoryItem);	
		
		
		//IMAGE_DIRECTORY_ENTRY_EXPORT
		IMAGE_DIRECTORY_ENTRY_EXPORT_START_ADDR			= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*0).toUpperCase();
		makeImageDirectoryEntryExport(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_EXPORT_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_IMPORT
		IMAGE_DIRECTORY_ENTRY_IMPORT_START_ADDR			= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*1).toUpperCase();
		makeImageDirectoryEntryImport(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_IMPORT_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_RESOURCE
		IMAGE_DIRECTORY_ENTRY_RESOURCE_START_ADDR		= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*2).toUpperCase();
		makeImageDirectoryEntryResource(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_RESOURCE_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_EXCEPTION
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_START_ADDR		= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*3).toUpperCase();
		makeImageDirectoryEntryException(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_EXCEPTION_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_SECURITY
		IMAGE_DIRECTORY_ENTRY_SECURITY_START_ADDR		= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*4).toUpperCase();
		makeImageDirectoryEntrySecurity(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_SECURITY_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_BASERELOC
		IMAGE_DIRECTORY_ENTRY_BASERELOC_START_ADDR		= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*5).toUpperCase();
		makeImageDirectoryEntryBasereloc(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_BASERELOC_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_DEBUG
		IMAGE_DIRECTORY_ENTRY_DEBUG_START_ADDR			= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*6).toUpperCase();
		makeImageDirectoryEntryDebug(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_DEBUG_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_ARCHITECTURE
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_START_ADDR		= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*7).toUpperCase();
		makeImageDirectoryEntryArchitecture(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_GLOBALPTR
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_START_ADDR		= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*8).toUpperCase();
		makeImageDirectoryEntryGlobalptr(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_GLOBALPTR_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_TLS
		IMAGE_DIRECTORY_ENTRY_TLS_START_ADDR			= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*9).toUpperCase();
		makeImageDirectoryEntryTls(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_TLS_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_START_ADDR	= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*10).toUpperCase();
		makeImageDirectoryEntryLoadConfig(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_START_ADDR	= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*11).toUpperCase();
		makeImageDirectoryEntryBoundImport(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_IAT
		IMAGE_DIRECTORY_ENTRY_IAT_START_ADDR			= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*12).toUpperCase();
		makeImageDirectoryEntryIat(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_IAT_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_START_ADDR	= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*13).toUpperCase();
		makeImageDirectoryEntryDelayImport(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_START_ADDR);
		
		
		//IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_START_ADDR	= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*14).toUpperCase();
		makeImageDirectoryEntryComDescriptor(DataDirectoryItem, IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_START_ADDR);
		
		//16番目は予約のため、0
		
		//IMAGE_SECTION_HEADER開始アドレス格納
		IMAGE_SECTION_HEADER_START_ADDR	= String.format("%08X", rawAddr+IMAGE_DATA_DIRECTORY_SIZE*16).toUpperCase();

	}
	
	private void makeImageDirectoryEntryExport(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_EXPORT
		name		= "IMAGE_DIRECTORY_ENTRY_EXPORT";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_EXPORTNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_EXPORT					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_EXPORTItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_EXPORT);
//		IMAGE_DIRECTORY_ENTRY_EXPORTItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_EXPORTItem);
		
		//Item取得
		IMAGE_DIRECTORY_ENTRY_EXPORT_ITEM	= IMAGE_DIRECTORY_ENTRY_EXPORTItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_EXPORTVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_EXPORT_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_EXPORTItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_EXPORTSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_EXPORT_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_EXPORTItem.getChildren().add(SizeItem);
				
	}	
	
	private void makeImageDirectoryEntryImport(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_IMPORT
		name		= "IMAGE_DIRECTORY_ENTRY_IMPORT";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_IMPORTNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_IMPORT					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_IMPORTItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_IMPORT);
//		IMAGE_DIRECTORY_ENTRY_IMPORTItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_IMPORTItem);
		
		//Item取得
		IMAGE_DIRECTORY_ENTRY_IMPORT_ITEM	= IMAGE_DIRECTORY_ENTRY_IMPORTItem;
	
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_IMPORTVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_IMPORT_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_IMPORTItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_IMPORTSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_IMPORT_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_IMPORTItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageDirectoryEntryResource(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_RESOURCE
		name		= "IMAGE_DIRECTORY_ENTRY_RESOURCE";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_RESOURCENotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_RESOURCE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_RESOURCEItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_RESOURCE);
//		IMAGE_DIRECTORY_ENTRY_RESOURCEItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_RESOURCEItem);
		
		//Item取得
		IMAGE_DIRECTORY_ENTRY_RESOURCE_ITEM	= IMAGE_DIRECTORY_ENTRY_RESOURCEItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_RESOURCEVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_RESOURCEItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_RESOURCESizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_RESOURCEItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageDirectoryEntryException(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_EXCEPTION
		name		= "IMAGE_DIRECTORY_ENTRY_EXCEPTION";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_EXCEPTIONNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_EXCEPTION					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_EXCEPTIONItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_EXCEPTION);
//		IMAGE_DIRECTORY_ENTRY_EXCEPTIONItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_EXCEPTIONItem);
		
		//Item取得
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_ITEM	= IMAGE_DIRECTORY_ENTRY_EXCEPTIONItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_EXCEPTIONVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_EXCEPTIONItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_EXCEPTIONSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_EXCEPTIONItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageDirectoryEntrySecurity(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_SECURITY
		name		= "IMAGE_DIRECTORY_ENTRY_SECURITY";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_SECURITYNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_SECURITY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_SECURITYItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_SECURITY);
//		IMAGE_DIRECTORY_ENTRY_SECURITYItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_SECURITYItem);
		
		//Item取得
		IMAGE_DIRECTORY_ENTRY_SECURITY_ITEM	= IMAGE_DIRECTORY_ENTRY_SECURITYItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_SECURITYVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_SECURITY_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_SECURITYItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_SECURITYSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_SECURITY_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_SECURITYItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageDirectoryEntryBasereloc(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_BASERELOC
		name		= "IMAGE_DIRECTORY_ENTRY_BASERELOC";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_BASERELOCNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_BASERELOC					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_BASERELOCItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_BASERELOC);
//		IMAGE_DIRECTORY_ENTRY_BASERELOCItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_BASERELOCItem);
		
		//Item取得
		IMAGE_DIRECTORY_ENTRY_BASERELOC_ITEM	= IMAGE_DIRECTORY_ENTRY_BASERELOCItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_BASERELOCVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_BASERELOCItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_BASERELOCSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_BASERELOCItem.getChildren().add(SizeItem);
		
	}
		
	private void makeImageDirectoryEntryDebug(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_DEBUG
		name		= "IMAGE_DIRECTORY_ENTRY_DEBUG";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_DEBUGNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_DEBUG					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_DEBUGItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_DEBUG);
//		IMAGE_DIRECTORY_ENTRY_DEBUGItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_DEBUGItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_DEBUG_ITEM	= IMAGE_DIRECTORY_ENTRY_DEBUGItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_DEBUGVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_DEBUG_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_DEBUGItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_DEBUGSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_DEBUG_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_DEBUGItem.getChildren().add(SizeItem);

	}
	
	private void makeImageDirectoryEntryArchitecture(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_ARCHITECTURE
		name		= "IMAGE_DIRECTORY_ENTRY_ARCHITECTURE";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_ARCHITECTURENotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_ARCHITECTURE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_ARCHITECTUREItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_ARCHITECTURE);
//		IMAGE_DIRECTORY_ENTRY_ARCHITECTUREItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_ARCHITECTUREItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_ITEM	= IMAGE_DIRECTORY_ENTRY_ARCHITECTUREItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_ARCHITECTUREVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_ARCHITECTUREItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_ARCHITECTURESizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_ARCHITECTURE_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_ARCHITECTUREItem.getChildren().add(SizeItem);
		
	}
		
	private void makeImageDirectoryEntryGlobalptr(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_GLOBALPTR
		name		= "IMAGE_DIRECTORY_ENTRY_GLOBALPTR";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_GLOBALPTRNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_GLOBALPTR					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_GLOBALPTRItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_GLOBALPTR);
//		IMAGE_DIRECTORY_ENTRY_GLOBALPTRItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_GLOBALPTRItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_ITEM	= IMAGE_DIRECTORY_ENTRY_GLOBALPTRItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_GLOBALPTRVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_GLOBALPTRItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_GLOBALPTRSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_GLOBALPTR_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_GLOBALPTRItem.getChildren().add(SizeItem);
		
	}
		
	private void makeImageDirectoryEntryTls(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_TLS
		name		= "IMAGE_DIRECTORY_ENTRY_TLS";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_TLSNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_TLS				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_TLSItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_TLS);
//		IMAGE_DIRECTORY_ENTRY_TLSItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_TLSItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_TLS_ITEM	= IMAGE_DIRECTORY_ENTRY_TLSItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_TLSVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_TLS_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_TLSItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_TLSSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_TLS_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_TLSItem.getChildren().add(SizeItem);

	}
	
	private void makeImageDirectoryEntryLoadConfig(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG
		name		= "IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG);
//		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_ITEM	= IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_LOAD_CONFIGItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageDirectoryEntryBoundImport(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT
		name		= "IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT);
//		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_ITEM	= IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORT_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_BOUND_IMPORTItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageDirectoryEntryIat(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_IAT
		name		= "IMAGE_DIRECTORY_ENTRY_IAT";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_IATNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_IAT				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_IATItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_IAT);
//		IMAGE_DIRECTORY_ENTRY_IATItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_IATItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_IAT_ITEM	= IMAGE_DIRECTORY_ENTRY_IATItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_IATVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_IAT_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_IATItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_IATSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_IAT_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_IATItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageDirectoryEntryDelayImport(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT
		name		= "IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT);
//		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_ITEM	= IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_DELAY_IMPORTItem.getChildren().add(SizeItem);

	}
	
	private void makeImageDirectoryEntryComDescriptor(TreeItem<WinPE32TreeTableRecord> DataDirectoryItem, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);
		
		//データ取得
		int dataSize	= IMAGE_DATA_DIRECTORY_SIZE;
		byte[] data		= getBintableBytes(startAddr, dataSize);
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= startAddr;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis = "";
		int v			= 0;
		String notes	= "";
		
		//IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR
		name		= "IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		= 0x0;
		size		= IMAGE_DATA_DIRECTORY_SIZE;
		value		= "";
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORNotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORItem 	= new TreeItem<>(IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR);
//		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORItem.setExpanded(true);
		DataDirectoryItem.getChildren().add(IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORItem);
		
		//Item保存
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_ITEM	= IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORItem;
		
		
		//0x00	DWORD	VirtualAddress
		name	= "VirtualAddress";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORVirtualAddressNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_RVA	= value;
		
		WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//		VirtualAddressItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORItem.getChildren().add(VirtualAddressItem);

		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	= offset + beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		v			= getStringToInt(value, false);
		analysis	= String.valueOf(v) + " bytes";
		notes		= IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORSizeNotes;
		beforesize	= size;
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTOR_RVA_SIZE	= v;
		
		WinPE32TreeTableRecord Size				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		IMAGE_DIRECTORY_ENTRY_COM_DESCRIPTORItem.getChildren().add(SizeItem);
		
	}
	
	private void makeImageSectionHeader(TreeItem<WinPE32TreeTableRecord> root, String strStartAddr) {
		
		//開始アドレス取得
		int startAddr	= getStringToInt(strStartAddr, false);

		//データ取得用変数
		int dataSize	= IMAGE_SECTION_HRADER_SIZE;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;	
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		Section	section	= null;
		
		//セクション情報
		String sectionName					= "";
		String sectionVirtualAddress		= "";
		int sectionVirtualSize				= 0;
		int sectionSizeOfRawData			= 0;
		String sectionPointerToRawData		= "";
		String sectionPointerToRelocations	= "";
		String sectionPointerToLinenumbers	= "";
		int sectionNumberOfRelocations		= 0;
		int sectionNumberOfLinenumbers		= 0;

		sectionList	= new ArrayList<Section>();
		
		for(int count=0; count<sectionCount; count++) {
					
			//IMAGE_SECTION_HEADER
			name		= "IMAGE_SECTION_HEADER";
			rawAddr		= startAddr + IMAGE_SECTION_HRADER_SIZE*count;
			raw			= rawAddr;
			offset		= 0x0;
			size		= IMAGE_SECTION_HRADER_SIZE;
			value		= "";
			analysis	= "";
			notes		= IMAGE_SECTION_HEADERNotes;
			beforesize	= 0;
			
			//データ取得		
			data		= getBintableBytes(rawAddr, dataSize);
			
			WinPE32TreeTableRecord IMAGE_SECTION_HEADER					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<WinPE32TreeTableRecord> IMAGE_SECTION_HEADERItem 	= new TreeItem<>(IMAGE_SECTION_HEADER);
//			IMAGE_SECTION_HEADERItem.setExpanded(true);
			root.getChildren().add(IMAGE_SECTION_HEADERItem);
			
			
			//0x00	Byte	Name
			name	= "Name";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= BYTE*IMAGE_SIZEOF_SHORT_NAME;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			for(int i=offset; i<offset+size; i++){
				analysis	+= String.format("%c", data[i]);
			}
			notes		= IMAGE_SECTION_HEADERNameNotes;
			beforesize	= size;
			sectionName	= analysis;
			section		= new Section(analysis);
			
			//セクション名再設定
			IMAGE_SECTION_HEADER.setName("IMAGE_SECTION_HEADER"+"("+analysis+")");	
			
			WinPE32TreeTableRecord Name				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> NameItem	= new TreeItem<>(Name);
			//NameItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(NameItem);		
			
			
			//0x08	DWORD	VirtualSize
			name	= "VirtualSize";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";
			notes		= IMAGE_SECTION_HEADERVirtualSizeNotes;
			beforesize	= size;
			sectionVirtualSize	= v;
			section.setVirtualSize(v);

			WinPE32TreeTableRecord VirtualSize					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> VirtualSizeItem	= new TreeItem<>(VirtualSize);
			//VirtualSizeItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(VirtualSizeItem);				
			
	
			//0x0c	DWORD	VirtualAddress
			name	= "VirtualAddress";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= IMAGE_SECTION_HEADERVirtualAddressNotes;
			beforesize	= size;
			sectionVirtualAddress	= value;
			section.setStrVirtualAddress(value);

			WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
			//VirtualAddressItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(VirtualAddressItem);	
			
			
			//0x10	DWORD	SizeOfRawData
			name	= "SizeOfRawData";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v)+" bytes";;
			notes		= IMAGE_SECTION_HEADERSizeOfRawDataNotes;
			beforesize	= size;
			sectionSizeOfRawData	= v;
			section.setRawSize(v);
			
			WinPE32TreeTableRecord SizeOfRawData				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> SizeOfRawDataItem	= new TreeItem<>(SizeOfRawData);
			//SizeOfRawDataItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(SizeOfRawDataItem);	
			
			
			//0x14	DWORD	PointerToRawData
			name	= "PointerToRawData";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= IMAGE_SECTION_HEADERPointerToRawDataNotes;
			beforesize	= size;
			sectionPointerToRawData	= value;
			section.setStrRawAddress(value);
			
			WinPE32TreeTableRecord PointerToRawData					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> PointerToRawDataItem	= new TreeItem<>(PointerToRawData);
			//PointerToRawDataItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(PointerToRawDataItem);	
			
			
			//0x18	DWORD	PointerToRelocations
			name	= "PointerToRelocations";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= IMAGE_SECTION_HEADERPointerToRelocationsNotes;
			beforesize	= size;
			sectionPointerToRelocations	= value;

			WinPE32TreeTableRecord PointerToRelocations					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> PointerToRelocationsItem	= new TreeItem<>(PointerToRelocations);
			//PointerToRelocationsItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(PointerToRelocationsItem);	
			
			
			//0x1c	DWORD	PointerToLinenumbers
			name	= "PointerToLinenumbers";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= IMAGE_SECTION_HEADERPointerToLinenumbersNotes;
			beforesize	= size;
			sectionPointerToLinenumbers	= value;

			WinPE32TreeTableRecord PointerToLinenumbers					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> PointerToLinenumbersItem	= new TreeItem<>(PointerToLinenumbers);
			//PointerToLinenumbersItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(PointerToLinenumbersItem);	
			
			
			//0x20	WORD	NumberOfRelocations
			name	= "NumberOfRelocations";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= WORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= IMAGE_SECTION_HEADERNumberOfRelocationsNotes;
			beforesize	= size;
			sectionNumberOfRelocations	= v;

			WinPE32TreeTableRecord NumberOfRelocations					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> NumberOfRelocationsItem	= new TreeItem<>(NumberOfRelocations);
			//NumberOfRelocationsItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(NumberOfRelocationsItem);	
			
			
			//0x22	WORD	NumberOfLinenumbers
			name	= "NumberOfLinenumbers";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= WORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= String.valueOf(v);
			notes		= IMAGE_SECTION_HEADERNumberOfLinenumbersNotes;
			beforesize	= size;
			sectionNumberOfLinenumbers	= v;

			WinPE32TreeTableRecord NumberOfLinenumbers					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> NumberOfLinenumbersItem	= new TreeItem<>(NumberOfLinenumbers);
			//NumberOfLinenumbersItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(NumberOfLinenumbersItem);	
			
			
			//0x24	DWORD	Characteristics
			name	= "Characteristics";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	= offset + beforesize;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			if((v & 0x00000008)>0) {
				analysis	+= "IMAGE_SCN_TYPE_NO_PAD(0x00000008)\n";
			}
			if((v & 0x00000020)>0) {
				analysis	+= "IMAGE_SCN_CNT_CODE(0x00000020)\n";
			}
			if((v & 0x00000040)>0) {
				analysis	+= "IMAGE_SCN_CNT_INITIALIZED_DATA(0x00000040)\n";
			}
			if((v & 0x00000080)>0) {
				analysis	+= "IMAGE_SCN_CNT_UNINITIALIZED_DATA(0x00000080)\n";
			}
			if((v & 0x00000100)>0) {
				analysis	+= "IMAGE_SCN_LNK_OTHER(0x00000100)\n";
			}
			if((v & 0x00000200)>0) {
				analysis	+= "IMAGE_SCN_LNK_INFO(0x00000200)\n";
			}
			if((v & 0x00000800)>0) {
				analysis	+= "IMAGE_SCN_LNK_REMOVE(0x00000800)\n";
			}
			if((v & 0x00001000)>0) {
				analysis	+= "IMAGE_SCN_LNK_COMDAT(0x00001000)\n";
			}
			if((v & 0x00008000)>0) {
				analysis	+= "IMAGE_SCN_GPREL(0x00008000)\n";
			}
			if((v & 0x00020000)>0) {
				analysis	+= "IMAGE_SCN_MEM_16BIT(0x00020000)\n";
			}
			if((v & 0x00100000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_1BYTES(0x00100000)\n";
			}
			if((v & 0x00200000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_2BYTES(0x00200000)\n";
			}
			if((v & 0x00300000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_4BYTES(0x00300000)\n";
			}
			if((v & 0x00400000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_8BYTES(0x00400000)\n";
			}
			if((v & 0x00500000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_16BYTES(0x00500000)\n";
			}
			if((v & 0x00600000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_32BYTES(0x00600000)\n";
			}
			if((v & 0x00700000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_64BYTES(0x00700000)\n";
			}			
			if((v & 0x00800000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_128BYTES(0x00800000)\n";
			}			
			if((v & 0x00900000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_256BYTES(0x00900000)\n";
			}			
			if((v & 0x00A00000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_512BYTES(0x00A00000)\n";
			}			
			if((v & 0x00B00000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_1024BYTES(0x00B00000)\n";
			}			
			if((v & 0x00C00000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_2048BYTES(0x00C00000)\n";
			}			
			if((v & 0x00D00000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_4096BYTES(0x00D00000)\n";
			}			
			if((v & 0x00E00000)>0) {
				analysis	+= "IMAGE_SCN_ALIGN_8192BYTES(0x00E00000)\n";
			}			
			if((v & 0x01000000)>0) {
				analysis	+= "IMAGE_SCN_LNK_NRELOC_OVFL(0x01000000)\n";
			}			
			if((v & 0x02000000)>0) {
				analysis	+= "IMAGE_SCN_MEM_DISCARDABLE(0x02000000)\n";
			}			
			if((v & 0x04000000)>0) {
				analysis	+= "IMAGE_SCN_MEM_NOT_CACHED(0x04000000)\n";
			}			
			if((v & 0x08000000)>0) {
				analysis	+= "IMAGE_SCN_MEM_NOT_PAGED(0x08000000)\n";
			}
			if((v & 0x10000000)>0) {
				analysis	+= "IMAGE_SCN_MEM_SHARED(0x10000000)\n";
			}
			if((v & 0x20000000)>0) {
				analysis	+= "IMAGE_SCN_MEM_EXECUTE(0x20000000)\n";
			}
			if((v & 0x40000000)>0) {
				analysis	+= "IMAGE_SCN_MEM_READ(0x40000000)\n";
			}
			if((v & 0x80000000)>0) {
				analysis	+= "IMAGE_SCN_MEM_WRITE(0x80000000)\n";
			}
			notes		= IMAGE_SECTION_HEADERCharacteristicsNotes;
			beforesize	= size;

			WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
			//CharacteristicsItem.setExpanded(true);
			IMAGE_SECTION_HEADERItem.getChildren().add(CharacteristicsItem);	

			//セクション情報保存
			section.setDiff();
			sectionList.add(section);		
			
			//SectionData作成
			if(sectionSizeOfRawData != 0 && !sectionPointerToRawData.equals("00000000")) {
				makeSectionData(root, sectionName, sectionVirtualSize, sectionVirtualAddress, sectionSizeOfRawData, sectionPointerToRawData, sectionPointerToRelocations, sectionPointerToLinenumbers, sectionNumberOfRelocations, sectionNumberOfLinenumbers);
			}
		}
		
		
		//SectionData終了からファイル末尾までの情報をリストに追加	
		int lastLineno	= binTableRecordList.size()-1;
		int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
		
		//REMAINING_DATA
		name		= "REMAINING_DATA";
		rawAddr		= getStringToInt(sectionPointerToRawData, false)+sectionSizeOfRawData;
		raw			= rawAddr;
		offset		= 0x0;
		size		= lastLineno*16+lastByteNum-(getStringToInt(sectionPointerToRawData, false)+sectionSizeOfRawData);
		if(size<0){
			size	= 0;
		}
		value		= "";
		analysis	= "";
		notes		= REMAINING_DATANotes;
		beforesize	= 0;

		//残りデータがあれば追加
		if(size>0){
			WinPE32TreeTableRecord REMAINING_DATA					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<WinPE32TreeTableRecord> REMAINING_DATAItem 	= new TreeItem<>(REMAINING_DATA);
//			REMAINING_DATAItem.setExpanded(true);
			root.getChildren().add(REMAINING_DATAItem);
		}

	
		//残りデータの情報を保存
		remainingDataRawAddr	= String.format("%08X", raw).toUpperCase();
		reaminingDataRawSize	= size;

//		System.out.println("remainingDataRawAddr="+remainingDataRawAddr);
//		System.out.println("reaminingDataRawSize="+reaminingDataRawSize);
		
	}
	
	
	private void makeSectionData(TreeItem<WinPE32TreeTableRecord> root, 
								 String sectionName,
								 int sectionVirtualSize,
								 String sectionVirtualAddress,
								 int sectionSizeOfRawData, 
								 String sectionPointerToRawData, 
								 String sectionPointerToRelocations, 
								 String sectionPointerToLinenumbers, 
								 int sectionNumberOfRelocations, 
								 int sectionNumberOfLinenumbers) {
				
		//開始アドレス取得
		int startSectionRawAddr		= getStringToInt(sectionPointerToRawData, false);
		int startSectionRVA			= getStringToInt(sectionVirtualAddress, false);
		int addrDiff				= startSectionRVA - startSectionRawAddr;		

		//データ取得用変数
		int dataSize	= sectionSizeOfRawData;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//SECTION_DATA
		name		= "SECTION_DATA"+"("+sectionName+")";
		rawAddr		= startSectionRawAddr;
		raw			= rawAddr;
		rva			= startSectionRVA;
		offset		= 0x0;
		size		= sectionSizeOfRawData;
		value		= "";
		analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
		notes		= SECTION_DATANotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord SECTION_DATA					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> SECTION_DATAItem 	= new TreeItem<>(SECTION_DATA);
//		SECTION_DATAItem.setExpanded(true);
		root.getChildren().add(SECTION_DATAItem);
		
	}
	
	private void makeImageExportDirectory(TreeItem<WinPE32TreeTableRecord> item){
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;

		
		//各テーブル
		int numFunctions	= 0;
		int numNames		= 0;
		int ordinalBase		= 0;
		TreeItem<WinPE32TreeTableRecord> EXPORT_ADDRESS_TABLEItem		= null;
		TreeItem<WinPE32TreeTableRecord> EXPORT_NAME_POINTER_TABLEItem	= null;
		TreeItem<WinPE32TreeTableRecord> EXPORT_ORDINAL_TABLEItem		= null;

		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_EXPORT_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_EXPORT_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_EXPORT_RVA, IMAGE_DIRECTORY_ENTRY_EXPORT_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_EXPORT_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;

					
					//IMAGE_EXPORT_DIRECTORY		
					name		= "IMAGE_EXPORT_DIRECTORY";
					rawAddr		+= beforesize;
					raw			= rawAddr;
					offset		+= beforesize;
					rva			= startSectionRVA + offset;
					size		= IMAGE_EXPORT_DIRECTORY_SIZE;
					value		= "";
					analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
					notes		= IMAGE_EXPORT_DIRECTORYNotes;
					beforesize	= 0;
					baseOffset	= offset;
					
					WinPE32TreeTableRecord IMAGE_EXPORT_DIRECTORY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					TreeItem<WinPE32TreeTableRecord> IMAGE_EXPORT_DIRECTORYItem 	= new TreeItem<>(IMAGE_EXPORT_DIRECTORY);
//					IMAGE_EXPORT_DIRECTORYItem.setExpanded(true);
					item.getChildren().add(IMAGE_EXPORT_DIRECTORYItem);
				
				
					//0x00	DWORD	Characteristics
					name	= "Characteristics";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= IMAGE_EXPORT_DIRECTORYCharacteristicsNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//					CharacteristicsItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(CharacteristicsItem);
					
					
					//0x04	DWORD	TimeDateStamp
					name	= "TimeDateStamp";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					Date date 	= new Date(Long.parseLong(value, 16)*1000);
					analysis	= date.toString();	
					notes		= IMAGE_EXPORT_DIRECTORYTimeDateStampNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord TimeDateStamp					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> TimeDateStampItem	= new TreeItem<>(TimeDateStamp);
//					TimeDateStampItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(TimeDateStampItem);				
					
					
					//0x08	WORD	MajorVersion
					name	= "MajorVersion";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= WORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= IMAGE_EXPORT_DIRECTORYMajorVersionNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord MajorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> MajorVersionItem	= new TreeItem<>(MajorVersion);
//					MajorVersionItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(MajorVersionItem);
					
					
					//0x0a	WORD	MinorVersion
					name	= "MinorVersion";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= WORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= IMAGE_EXPORT_DIRECTORYMinorVersionNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord MinorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> MinorVersionItem	= new TreeItem<>(MinorVersion);
//					MinorVersionItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(MinorVersionItem);
					
					
					//0x0c	DWORD	Name
					name	= "Name";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";	
					v	= getStringToInt(value, false);
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
					}
					notes		= IMAGE_EXPORT_DIRECTORYNameNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord Name					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> NameItem	= new TreeItem<>(Name);
//					NameItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(NameItem);
					
					//Name作成
					makeImageExportDirectoryName(NameItem, value, String.format("%08X", v).toUpperCase());				
					
					
					//0x10	DWORD	Base
					name	= "Base";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					v	= getStringToInt(value, false);
					analysis	= "OrdinalBase="+v;
					notes		= IMAGE_EXPORT_DIRECTORYBaseNotes;
					beforesize	= size;
					ordinalBase	= v;
					
					WinPE32TreeTableRecord Base					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> BaseItem	= new TreeItem<>(Base);
//					BaseItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(BaseItem);
					
					
					//0x14	DWORD	NumberOfFunctions
					name	= "NumberOfFunctions";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					v			= getStringToInt(value, false);
					analysis	= String.valueOf(v);
					notes		= IMAGE_EXPORT_DIRECTORYNumberOfFunctionsNotes;
					beforesize	= size;
					numFunctions	= v;					
					
					WinPE32TreeTableRecord NumberOfFunctions					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> NumberOfFunctionsItem		= new TreeItem<>(NumberOfFunctions);
//					NumberOfFunctionsItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(NumberOfFunctionsItem);
					
					
					//0x18	DWORD	NumberOfNames
					name	= "NumberOfNames";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					v			= getStringToInt(value, false);
					analysis	= String.valueOf(v);
					notes		= IMAGE_EXPORT_DIRECTORYNumberOfNamesNotes;
					beforesize	= size;
					numNames	= v;
					
					WinPE32TreeTableRecord NumberOfNames				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> NumberOfNamesItem	= new TreeItem<>(NumberOfNames);
//					NumberOfNamesItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(NumberOfNamesItem);
					
					
					//0x1c	DWORD	AddressOfFunctions
					name	= "AddressOfFunctions";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					v	= getStringToInt(value, false);
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
					}
					notes		= IMAGE_EXPORT_DIRECTORYAddressOfFunctionsNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord AddressOfFunctions					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> AddressOfFunctionsItem		= new TreeItem<>(AddressOfFunctions);
//					AddressOfFunctionsItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(AddressOfFunctionsItem);
					
					//EXPORT_ADDRESS_TABLE作成
					EXPORT_ADDRESS_TABLEItem	= makeExportAddressTable(AddressOfFunctionsItem, value, String.format("%08X", v).toUpperCase(), numFunctions);
					
					
					//0x20	DWORD	AddressOfNames
					name	= "AddressOfNames";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					v	= getStringToInt(value, false);
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
					}
					notes		= IMAGE_EXPORT_DIRECTORYAddressOfNamesNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord AddressOfNames				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> AddressOfNamesItem	= new TreeItem<>(AddressOfNames);
//					AddressOfNamesItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(AddressOfNamesItem);
					
					//EXPORT_NAME_POINTER_TABLE作成
					EXPORT_NAME_POINTER_TABLEItem = makeExportNamePointerTable(AddressOfNamesItem, value, String.format("%08X", v).toUpperCase(), numNames);

					
					//0x24	DWORD	AddressOfNameOrdinals
					name	= "AddressOfNameOrdinals";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					v	= getStringToInt(value, false);
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
					}
					notes		= IMAGE_EXPORT_DIRECTORYAddressOfNameOrdinalsNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord AddressOfNameOrdinals				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> AddressOfNameOrdinalsItem	= new TreeItem<>(AddressOfNameOrdinals);
//					AddressOfNameOrdinalsItem.setExpanded(true);
					IMAGE_EXPORT_DIRECTORYItem.getChildren().add(AddressOfNameOrdinalsItem);
					
					//EXPORT_ORDINAL_TABLE作成
					EXPORT_ORDINAL_TABLEItem = makeExportOrdinalTable(AddressOfNameOrdinalsItem, value, String.format("%08X", v).toUpperCase(), numNames);
				
					
					//EXPORT_SYMBOL作成
					makeExportSymbol(ordinalBase, EXPORT_ADDRESS_TABLEItem, numFunctions, EXPORT_NAME_POINTER_TABLEItem, numNames, EXPORT_ORDINAL_TABLEItem);
					

				}
			}
		}
	}
	
	private void makeImageExportDirectoryName(TreeItem<WinPE32TreeTableRecord> item,
											  String strRVAAddr, 
											  String strRawAddr){
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int offset		= 0;
		int rva			= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";
		int addr		= 0;
		
		//0x00	BYTE	NAME[1];
		name		= "Name";
		rawAddr		= startRawAddr;
		raw			= rawAddr;
		offset		+= beforesize;
		rva			= startRVA + offset;
		size		= 0;
		value		= "";
		analysis	= "";
		addr		= raw;
		do{
			//データ取得
			dataSize	= BYTE;
			data		= getBintableBytes(addr, dataSize);
			value		+= String.format("%02X", data[0]).toUpperCase();
			analysis	+= String.format("%c", data[0]);
			addr++;
			size++;
		}while(data[0] != 0);
		notes		= "";
		beforesize	= size;
		v			= 0;
		
		WinPE32TreeTableRecord Name					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> NameItem	= new TreeItem<>(Name);
//		NameItem.setExpanded(true);
		item.getChildren().add(NameItem);	
		
	}
	
	
	private TreeItem<WinPE32TreeTableRecord> makeExportAddressTable(TreeItem<WinPE32TreeTableRecord> item,
																	String strRVAAddr, 
																	String strRawAddr,
																	int numberOfFunctions) {
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		int count		= 0;

		//データ取得		
		dataSize		= DWORD*numberOfFunctions;
		data			= getBintableBytes(startRawAddr, dataSize);
		
		
		//EXPORT_ADDRESS_TABLE
		name		= "EXPORT_ADDRESS_TABLE";
		rawAddr		= startRawAddr;
		raw			= rawAddr;
		offset		= 0x0;
		rva			= startRVA;
		size		= DWORD*numberOfFunctions;
		value		= "";
		analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
		notes		= EXPORT_ADDRESS_TABLENotes;
		beforesize	= 0;
		v			= 0;
		
		WinPE32TreeTableRecord EXPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> EXPORT_ADDRESS_TABLEItem 	= new TreeItem<>(EXPORT_ADDRESS_TABLE);
//		EXPORT_ADDRESS_TABLEItem.setExpanded(true);
		item.getChildren().add(EXPORT_ADDRESS_TABLEItem);

	
		for(int c=0; c<numberOfFunctions; c++){
			
			//0x00	DWORD	AddressOfFunction
			name	= "AddressOfFunction"+"["+c+"]";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	+= beforesize;
			rva		= startRVA + offset;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";		
			notes		= EXPORT_ADDRESS_TABLEAddressOfFunctionNotes;
			beforesize	= size;
			
			WinPE32TreeTableRecord AddressOfFunction				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> AddressOfFunctionItem	= new TreeItem<>(AddressOfFunction);
//			AddressOfFunctionItem.setExpanded(true);
			EXPORT_ADDRESS_TABLEItem.getChildren().add(AddressOfFunctionItem);

		}
		
		return EXPORT_ADDRESS_TABLEItem;
	}
	
	private TreeItem<WinPE32TreeTableRecord> makeExportNamePointerTable(TreeItem<WinPE32TreeTableRecord> item,
																		String strRVAAddr, 
																		String strRawAddr,
																		int numberOfNames) {
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	

		//データ取得		
		dataSize		= DWORD*numberOfNames;
		data			= getBintableBytes(startRawAddr, dataSize);
		
		
		//EXPORT_NAME_POINTER_TABLE
		name		= "EXPORT_NAME_POINTER_TABLE";
		rawAddr		= startRawAddr;
		raw			= rawAddr;
		offset		= 0x0;
		rva			= startRVA;
		size		= DWORD*numberOfNames;
		value		= "";
		analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
		notes		= EXPORT_NAME_POINTER_TABLENotes;
		beforesize	= 0;
		v			= 0;
		
		WinPE32TreeTableRecord EXPORT_NAME_POINTER_TABLE				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> EXPORT_NAME_POINTER_TABLEItem 	= new TreeItem<>(EXPORT_NAME_POINTER_TABLE);
//		EXPORT_NAME_POINTER_TABLEItem.setExpanded(true);
		item.getChildren().add(EXPORT_NAME_POINTER_TABLEItem);

	
		for(int c=0; c<numberOfNames; c++){
			
			//0x00	DWORD	AddressOfNames
			name	= "AddressOfNames"+"["+c+"]";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	+= beforesize;
			rva		= startRVA + offset;
			size	= DWORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v	= getStringToInt(value, false);
			if(v != 0){
				v -= addrDiff;
				analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
			}
			notes		= EXPORT_NAME_POINTER_TABLEAddressOfNamesNotes;
			beforesize	= size;
			
			WinPE32TreeTableRecord AddressOfNames				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> AddressOfNamesItem	= new TreeItem<>(AddressOfNames);
//			AddressOfNamesItem.setExpanded(true);
			EXPORT_NAME_POINTER_TABLEItem.getChildren().add(AddressOfNamesItem);
			
			//Name作成
			makeImageExportDirectoryName(AddressOfNamesItem, value, String.format("%08X", v).toUpperCase());				
			
		}
		
		return EXPORT_NAME_POINTER_TABLEItem;
	}
	
	private TreeItem<WinPE32TreeTableRecord> makeExportOrdinalTable(TreeItem<WinPE32TreeTableRecord> item,
									 								String strRVAAddr, 
									 								String strRawAddr,
									 								int numberOfNames) {
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		int count		= 0;

		//データ取得		
		dataSize		= WORD*numberOfNames;
		data			= getBintableBytes(startRawAddr, dataSize);
		
		
		//EXPORT_ORDINAL_TABLE
		name		= "EXPORT_ORDINAL_TABLE";
		rawAddr		= startRawAddr;
		raw			= rawAddr;
		offset		= 0x0;
		rva			= startRVA;
		size		= WORD*numberOfNames;
		value		= "";
		analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
		notes		= EXPORT_ORDINAL_TABLENotes;
		beforesize	= 0;
		v			= 0;
		
		WinPE32TreeTableRecord EXPORT_ORDINAL_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> EXPORT_ORDINAL_TABLEItem 	= new TreeItem<>(EXPORT_ORDINAL_TABLE);
//		EXPORT_ORDINAL_TABLEItem.setExpanded(true);
		item.getChildren().add(EXPORT_ORDINAL_TABLEItem);

	
		for(int c=0; c<numberOfNames; c++){
			
			//0x00	WORD	Ordinals
			name	= "Ordinals"+"["+c+"]";
			rawAddr	+= beforesize;
			raw		= rawAddr;
			offset	+= beforesize;
			rva		= startRVA + offset;
			size	= WORD;
			value	= "";
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			v			= getStringToInt(value, false);
			analysis	= Integer.toString(v);
			notes		= EXPORT_ORDINAL_TABLEOrdinalsNotes;
			beforesize	= size;
			
			WinPE32TreeTableRecord Ordinals				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> OrdinalsItem	= new TreeItem<>(Ordinals);
//			OrdinalsItem.setExpanded(true);
			EXPORT_ORDINAL_TABLEItem.getChildren().add(OrdinalsItem);

		}
		
		return EXPORT_ORDINAL_TABLEItem;
	}
	
	private void makeExportSymbol(int ordinalBase,
								  TreeItem<WinPE32TreeTableRecord> EXPORT_ADDRESS_TABLEItem,
								  int numFunctions,
								  TreeItem<WinPE32TreeTableRecord> EXPORT_NAME_POINTER_TABLEItem,
								  int numNames,
								  TreeItem<WinPE32TreeTableRecord> EXPORT_ORDINAL_TABLEItem) {
		
		ObservableList<TreeItem<WinPE32TreeTableRecord>> EXPORT_ADDRESS_TABLEItem_list	= EXPORT_ADDRESS_TABLEItem.getChildren();
		Iterator<TreeItem<WinPE32TreeTableRecord>> EXPORT_ADDRESS_TABLEItem_iterator	= EXPORT_ADDRESS_TABLEItem_list.iterator();
		TreeItem<WinPE32TreeTableRecord> AddressOfFunctionItem							= null;
		WinPE32TreeTableRecord AddressOfFunctionRecord									= null;
		
		ObservableList<TreeItem<WinPE32TreeTableRecord>> EXPORT_NAME_POINTER_TABLEItem_list = EXPORT_NAME_POINTER_TABLEItem.getChildren();
		
		ObservableList<TreeItem<WinPE32TreeTableRecord>> EXPORT_ORDINAL_TABLEItem_list = EXPORT_ORDINAL_TABLEItem.getChildren();
		
		
		//設定用変数
		String name		= "";
		String value	= "";
		String analysis	= "";
		String notes	= "";	
		
		//
		int addressRecordIndex	= 0;
		int symbolRVA			= 0;

			
		while(EXPORT_ADDRESS_TABLEItem_iterator.hasNext()){
			AddressOfFunctionItem		= (TreeItem<WinPE32TreeTableRecord>)EXPORT_ADDRESS_TABLEItem_iterator.next();
			AddressOfFunctionRecord		= AddressOfFunctionItem.getValue();
			
			//ExportSymbolRVA
			name		= "ExportSymbolRVA";
			value		= "";
			analysis	= "";
			notes		= EXPORT_ADDRESS_TABLEExportSymbolRVANotes;
			
			//エクスポートシンボルのRVA取得
			symbolRVA	= getStringToInt(AddressOfFunctionRecord.getValue(), false);
			
			WinPE32TreeTableRecord ExportSymbolRVA					= new WinPE32TreeTableRecord(name, AddressOfFunctionRecord.getRaw(), AddressOfFunctionRecord.getRVA(), AddressOfFunctionRecord.getOffset(), AddressOfFunctionRecord.getSize(), AddressOfFunctionRecord.getValue(), AddressOfFunctionRecord.getAnalysis(), notes);		
			TreeItem<WinPE32TreeTableRecord> ExportSymbolRVAItem	= new TreeItem<>(ExportSymbolRVA);
//			ExportSymbolRVAItem.setExpanded(true);
			AddressOfFunctionItem.getChildren().add(ExportSymbolRVAItem);
			
			
			//Ordinal
			int ordinal				= 0;
			int ordinalRecordIntex	= 0;
			
			name		= "Ordinal";
			ordinal		= addressRecordIndex + ordinalBase;			
			analysis	= "";
			notes		= EXPORT_ADDRESS_TABLEOrdinalNotes;
			
			Iterator<TreeItem<WinPE32TreeTableRecord>> EXPORT_ORDINAL_TABLEItem_iterator	= EXPORT_ORDINAL_TABLEItem_list.iterator();
			TreeItem<WinPE32TreeTableRecord> OrdinalsItem									= null;	
			WinPE32TreeTableRecord OrdinalRecord											= null;
				
			while(EXPORT_ORDINAL_TABLEItem_iterator.hasNext()){
				OrdinalsItem		= (TreeItem<WinPE32TreeTableRecord>)EXPORT_ORDINAL_TABLEItem_iterator.next();
				OrdinalRecord		= OrdinalsItem.getValue();
				int ov				= getStringToInt(OrdinalRecord.getValue(), false);
				
				if(addressRecordIndex==ov){	
					
					analysis	= "AddressOfFunctionIndex="+OrdinalRecord.getName()+"="+addressRecordIndex+"\n";	
					analysis	+= "Ordinal=AddressOfFunctionIndex+OrdinalBase="+ordinal;
					
					WinPE32TreeTableRecord Ordinal					= new WinPE32TreeTableRecord(name, "", "", "", "", Integer.toString(ordinal), analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> OrdinalItem	= new TreeItem<>(Ordinal);
//					OrdinalItem.setExpanded(true);
					AddressOfFunctionItem.getChildren().add(OrdinalItem);
					
					//Ordinal[ordinalRecordIntex]
					OrdinalItem.getChildren().add(OrdinalsItem);
					
					break;
					
				}		
					
				ordinalRecordIntex++;
			}		
			
			if(ordinalRecordIntex>=EXPORT_ORDINAL_TABLEItem_list.size()){
				WinPE32TreeTableRecord Ordinal					= new WinPE32TreeTableRecord(name, "", "", "", "", "", analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> OrdinalItem	= new TreeItem<>(Ordinal);
//				OrdinalItem.setExpanded(true);
				AddressOfFunctionItem.getChildren().add(OrdinalItem);
				
				ordinalRecordIntex=-1;
			}
			
			
			//ExportSymbolName
			name		= "ExportSymbolName";
			analysis	= "";
			notes		= EXPORT_ADDRESS_TABLEExportSymbolNameNotes;

			if(ordinalRecordIntex!=-1){			
				TreeItem<WinPE32TreeTableRecord> AddressOfNamesItem		= EXPORT_NAME_POINTER_TABLEItem_list.get(ordinalRecordIntex);		
				WinPE32TreeTableRecord AddressOfNamesRecord				= AddressOfNamesItem.getValue();
			
				analysis	= AddressOfNamesRecord.getName();
				
				WinPE32TreeTableRecord ExportSymbolName					= new WinPE32TreeTableRecord(name, AddressOfNamesRecord.getRaw(), AddressOfNamesRecord.getRVA(), AddressOfNamesRecord.getOffset(), AddressOfNamesRecord.getSize(), AddressOfNamesRecord.getValue(), analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> ExportSymbolNameItem	= new TreeItem<>(ExportSymbolName);
//				ExportSymbolNameItem.setExpanded(true);
				AddressOfFunctionItem.getChildren().add(ExportSymbolNameItem);

				//AddressOfNames[ordinalRecordIntex]
				ExportSymbolNameItem.getChildren().add(AddressOfNamesItem.getChildren().get(0));
				
			}else{			
				WinPE32TreeTableRecord ExportSymbolName					= new WinPE32TreeTableRecord(name, "", "", "", "", "", analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> ExportSymbolNameItem	= new TreeItem<>(ExportSymbolName);
//				ExportSymbolNameItem.setExpanded(true);
				AddressOfFunctionItem.getChildren().add(ExportSymbolNameItem);

			}
			

			//ForwardedTo
			name		= "ForwardedTo";
			analysis	= "";
			notes		= EXPORT_ADDRESS_TABLEForwardedToNotes;		
			
			if(symbolRVA>=getStringToInt(IMAGE_DIRECTORY_ENTRY_EXPORT_RVA, false) && symbolRVA<=getStringToInt(IMAGE_DIRECTORY_ENTRY_EXPORT_RVA, false)+IMAGE_DIRECTORY_ENTRY_EXPORT_RVA_SIZE){
				analysis	= "True";

			}else{
				analysis	= "false";
				
			}
			WinPE32TreeTableRecord ForwardedTo					= new WinPE32TreeTableRecord(name, "", "", "", "", "", analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> ForwardedToItem	= new TreeItem<>(ForwardedTo);
//			ForwardedToItem.setExpanded(true);
			AddressOfFunctionItem.getChildren().add(ForwardedToItem);
			
			
			addressRecordIndex++;
		
		}
	}
	
	private void makeImageImportDescriptor(TreeItem<WinPE32TreeTableRecord> item){
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//カウント
		int count		= 0;
		int iatCount	= 0;
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;
			
		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_IMPORT_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_IMPORT_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_IMPORT_RVA, IMAGE_DIRECTORY_ENTRY_IMPORT_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_IMPORT_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;
					
					do{		
						//IMAGE_IMPORT_DESCRIPTOR			
						name	= "IMAGE_IMPORT_DESCRIPTOR"+"["+count+"]";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= IMAGE_IMPORT_DESCRIPTOR_SIZE;
						value	= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_IMPORT_DESCRIPTORNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_IMPORT_DESCRIPTOR					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_IMPORT_DESCRIPTORItem 	= new TreeItem<>(IMAGE_IMPORT_DESCRIPTOR);
//						IMAGE_IMPORT_DESCRIPTORItem.setExpanded(true);
						item.getChildren().add(IMAGE_IMPORT_DESCRIPTORItem);
					
					
						//0x00	PIMAGE_THUNK_DATA	OriginalFirstThunk
						name	= "OriginalFirstThunk";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= PIMAGE_THUNK_DATA_SIZE;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}						
						notes		= IMAGE_IMPORT_DESCRIPTOROriginalFirstThunkNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord OriginalFirstThunk				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> OriginalFirstThunkItem	= new TreeItem<>(OriginalFirstThunk);
//						OriginalFirstThunkItem.setExpanded(true);
						IMAGE_IMPORT_DESCRIPTORItem.getChildren().add(OriginalFirstThunkItem);

						//IMPORT_NAME_TABLE作成
						if(!value.equals("00000000")){
							makeImportNameTable(OriginalFirstThunkItem, value, String.format("%08X", v).toUpperCase());
						}
					
						
						//0x04	DWORD	TimeDateStamp
						name	= "TimeDateStamp";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						Date date 	= new Date(Long.parseLong(value, 16)*1000);
						analysis	= date.toString();	
						notes		= IMAGE_IMPORT_DESCRIPTORTimeDateStampNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord TimeDateStamp				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> TimeDateStampItem	= new TreeItem<>(TimeDateStamp);
//						TimeDateStampItem.setExpanded(true);
						IMAGE_IMPORT_DESCRIPTORItem.getChildren().add(TimeDateStampItem);
						
						
						//0x08	DWORD	ForwarderChain
						name	= "ForwarderChain";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						notes		= IMAGE_IMPORT_DESCRIPTORForwarderChainNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord ForwarderChain				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> ForwarderChainItem	= new TreeItem<>(ForwarderChain);
//						ForwarderChainItem.setExpanded(true);
						IMAGE_IMPORT_DESCRIPTORItem.getChildren().add(ForwarderChainItem);
						
						
						//0x0c	DWORD	Name
						name	= "Name";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}	
						notes		= IMAGE_IMPORT_DESCRIPTORNameNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Name				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> NameItem	= new TreeItem<>(Name);
//						NameItem.setExpanded(true);
						IMAGE_IMPORT_DESCRIPTORItem.getChildren().add(NameItem);
						
						//DLL_NAME作成
						if(!value.equals("00000000")){
							makeImportDllName(NameItem, value, String.format("%08X", v).toUpperCase());
						}

						
						//0x10	PIMAGE_THUNK_DATA	FirstThunk
						name	= "FirstThunk";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= PIMAGE_THUNK_DATA_SIZE;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}	
						notes		= IMAGE_IMPORT_DESCRIPTORFirstThunkNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord FirstThunk				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> FirstThunkItem	= new TreeItem<>(FirstThunk);
//						FirstThunkItem.setExpanded(true);
						IMAGE_IMPORT_DESCRIPTORItem.getChildren().add(FirstThunkItem);

						//IMPORT_ADDRESS_TABLE作成
						if(!value.equals("00000000")){
							iatCount	= makeImportAddressTable(FirstThunkItem, value, String.format("%08X", v).toUpperCase(), iatCount);
						}
						count++;
					
					}while(!value.equals("00000000"));
					
				}				
			}		
		}
	}	

	private void makeImportNameTable(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= startRawAddr;
		int raw			= 0;
		int rva			= startRVA;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		int count		= 0;
		
		if(magicNumber.equals("010B")) {	//PE32
			
			dataSize	= IMAGE_THUNK_DATA32_SIZE;
			
			do{									
				//IMPORT_NAME_TABLE
				name		= "IMPORT_NAME_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA32_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= IMPORT_NAME_TABLENotes;
				beforesize	= 0;
				v			= 0;
				
				WinPE32TreeTableRecord IMPORT_NAME_TABLE				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> IMPORT_NAME_TABLEItem 	= new TreeItem<>(IMPORT_NAME_TABLE);
//				IMPORT_NAME_TABLEItem.setExpanded(true);
				item.getChildren().add(IMPORT_NAME_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	DWORD	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		+= beforesize;
				size	= DWORD;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";			
				v	= getStringToInt(value, false);			
				if((v & 0x80000000) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(v & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= IMPORT_NAME_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();
					}
					notes		= IMPORT_NAME_TABLEAddressOfDataNotes;		
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				IMPORT_NAME_TABLEItem.getChildren().add(recordItem);
				
				//IMAGE_IMPORT_BY_NAME作成			
				if((v & 0x80000000) == 0 && !value.equals("00000000")) { //AddressOfDataなら
					makeImageImportByName(recordItem, value, String.format("%08X", v).toUpperCase());
				}
				
				count++;
				
			}while(!value.equals("00000000"));

					
		}else if(magicNumber.equals("020B")){	//PE32+
			
			dataSize	= IMAGE_THUNK_DATA64_SIZE;
			
			do{
				//IMPORT_NAME_TABLE
				name		= "IMPORT_NAME_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA64_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= IMPORT_NAME_TABLENotes;
				beforesize	= 0;
				
				WinPE32TreeTableRecord IMPORT_NAME_TABLE				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> IMPORT_NAME_TABLEItem 	= new TreeItem<>(IMPORT_NAME_TABLE);
//				IMPORT_NAME_TABLEItem.setExpanded(true);
				item.getChildren().add(IMPORT_NAME_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	ULONGLONG	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		= rva + beforesize;
				size	= ULONGLONG;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";
				vl	= getStringToLong(value, false);			
				if((vl & Long.MIN_VALUE) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(vl & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= IMPORT_NAME_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(vl != 0){
						vl -= addrDiff;
						analysis	= "Raw=0x" + String.format("%016X", vl).toUpperCase();
					}
					notes		= IMPORT_NAME_TABLEAddressOfDataNotes;
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				IMPORT_NAME_TABLEItem.getChildren().add(recordItem);	
				
				//IMAGE_IMPORT_BY_NAME作成			
				if((vl & Long.MIN_VALUE) == 0 && !value.equals("0000000000000000")) { //Ordinalなら
					makeImageImportByName(recordItem, value.substring(8, 16), String.format("%08X", vl).toUpperCase());
				}				
				
				count++;	
				
			}while(!value.equals("0000000000000000"));
				
		}
	}
	
	private void makeImageImportByName(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr) {
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int offset		= 0;
		int rva			= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";
		int addr		= 0;
		
		if(magicNumber.equals("010B")) {	//PE32			
			//IMAGE_IMPORT_BY_NAME
			name		= "IMAGE_IMPORT_BY_NAME";
			rawAddr		= startRawAddr;
			raw			= rawAddr;
			rva			= startRVA;
			offset		= 0x0;
			size		= 0;
			value		= "";
			analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
			notes		= IMAGE_IMPORT_BY_NAMENotes;
			beforesize	= 0;
			v			= 0;
			
			WinPE32TreeTableRecord IMAGE_IMPORT_BY_NAME					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<WinPE32TreeTableRecord> IMAGE_IMPORT_BY_NAMEItem 	= new TreeItem<>(IMAGE_IMPORT_BY_NAME);
//			IMAGE_IMPORT_BY_NAMEItem.setExpanded(true);
			item.getChildren().add(IMAGE_IMPORT_BY_NAMEItem);

			
			//0x00	WORD	Hint
			name		= "Hint";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		+= beforesize;
			rva			= startRVA + offset;
			size		= WORD;
			value		= "";			
			//データ取得		
			dataSize	= size;
			data		= getBintableBytes(raw, dataSize);
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= IMAGE_IMPORT_BY_NAMEHintNotes;
			beforesize	= size;
			v			= 0;
			
			WinPE32TreeTableRecord Hint					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> HintItem	= new TreeItem<>(Hint);
//			HintItem.setExpanded(true);
			IMAGE_IMPORT_BY_NAMEItem.getChildren().add(HintItem);
			
			
			//0x02	BYTE	NAME[1];
			name		= "NAME";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		+= beforesize;
			rva			= startRVA + offset;
			size		= 0;
			value		= "";
			analysis	= "";
			addr		= raw;
			do{
				//データ取得
				dataSize	= BYTE;
				data		= getBintableBytes(addr, dataSize);
				value		+= String.format("%02X", data[0]).toUpperCase();
				analysis	+= String.format("%c", data[0]);
				addr++;
				size++;
			}while(data[0] != 0);
			notes		= IMAGE_IMPORT_BY_NAMENAMENotes;
			beforesize	= size;
			v			= 0;
						
			WinPE32TreeTableRecord NAME					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> NAMEItem	= new TreeItem<>(NAME);
//			NAMEItem.setExpanded(true);
			IMAGE_IMPORT_BY_NAMEItem.getChildren().add(NAMEItem);	
					
			//IMAGE_IMPORT_BY_NAMEサイズ更新
			size	+= WORD;
			IMAGE_IMPORT_BY_NAME.setSize(String.format("%08X", size).toUpperCase());
					
		}else if(magicNumber.equals("020B")){	//PE32+
			//IMAGE_IMPORT_BY_NAME
			name		= "IMAGE_IMPORT_BY_NAME";
			rawAddr		= startRawAddr;
			raw			= rawAddr;
			offset		= 0x0;
			rva			= startRVA;
			size		= 0;
			value		= "";
			analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
			notes		= IMAGE_IMPORT_BY_NAMENotes;
			beforesize	= 0;
			v			= 0;
			
			WinPE32TreeTableRecord IMAGE_IMPORT_BY_NAME					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<WinPE32TreeTableRecord> IMAGE_IMPORT_BY_NAMEItem 	= new TreeItem<>(IMAGE_IMPORT_BY_NAME);
//			IMAGE_IMPORT_BY_NAMEItem.setExpanded(true);
			item.getChildren().add(IMAGE_IMPORT_BY_NAMEItem);

			
			//0x00	WORD	Hint
			name		= "Hint";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		+= beforesize;
			rva			= startRVA + offset;
			size		= WORD;
			value		= "";			
			//データ取得		
			dataSize	= size;
			data		= getBintableBytes(raw, dataSize);
			for(int i=offset+size-1; i>=offset; i-- ){
				value	+= String.format("%02X", data[i]).toUpperCase();
			}
			analysis	= "";
			notes		= IMAGE_IMPORT_BY_NAMEHintNotes;
			beforesize	= size;
			v			= 0;
			
			WinPE32TreeTableRecord Hint					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> HintItem	= new TreeItem<>(Hint);
//			HintItem.setExpanded(true);
			IMAGE_IMPORT_BY_NAMEItem.getChildren().add(HintItem);
			
			
			//0x02	BYTE	NAME[1];
			name		= "NAME";
			rawAddr		+= beforesize;
			raw			= rawAddr;
			offset		= offset + beforesize;
			rva			= startRVA + offset;
			size		= 0;
			value		= "";
			analysis	= "";
			addr		= raw;
			do{
				//データ取得
				dataSize	= BYTE;
				data		= getBintableBytes(addr, dataSize);
				value		+= String.format("%02X", data[0]).toUpperCase();
				analysis	+= String.format("%c", data[0]);
				addr++;
				size++;
			}while(data[0] != 0);
			notes		= IMAGE_IMPORT_BY_NAMENAMENotes;
			beforesize	= size;
			v			= 0;
			
			WinPE32TreeTableRecord NAME					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
			TreeItem<WinPE32TreeTableRecord> NAMEItem	= new TreeItem<>(NAME);
//			NAMEItem.setExpanded(true);
			IMAGE_IMPORT_BY_NAMEItem.getChildren().add(NAMEItem);	
						
			//IMAGE_IMPORT_BY_NAMEサイズ更新
			size	+= WORD;
			IMAGE_IMPORT_BY_NAME.setSize(String.format("%08X", size).toUpperCase());		
			
		}
	}
	
	private void makeImportDllName(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr) {
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
//		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int offset		= 0;
		int rva			= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
//		long vl			= 0;
		String notes	= "";
		int addr		= 0;
		
		//0x00	BYTE	DllName[1];
		name		= "DllName";
		rawAddr		= startRawAddr;
		raw			= rawAddr;
		offset		= offset + beforesize;
		rva			= startRVA;
		size		= 0;
		value		= "";
		analysis	= "";
		addr		= raw;
		do{
			//データ取得
			dataSize	= BYTE;
			data		= getBintableBytes(addr, dataSize);
			value		+= String.format("%02X", data[0]).toUpperCase();
			analysis	+= String.format("%c", data[0]);
			addr++;
			size++;
		}while(data[0] != 0);
		notes		= IMPORTDllNameNotes;
		beforesize	= size;
		v			= 0;
		
		WinPE32TreeTableRecord DllName					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> DllNameItem	= new TreeItem<>(DllName);
//		DllNameItem.setExpanded(true);
		item.getChildren().add(DllNameItem);	
		
	}
	
	private int makeImportAddressTable(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr, int count){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= startRawAddr;
		int raw			= 0;
		int rva			= startRVA;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		
		
		if(magicNumber.equals("010B")) {	//PE32
			
			dataSize	= IMAGE_THUNK_DATA32_SIZE;
			
			do{									
				//IMPORT_ADDRESS_TABLE
				name		= "IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA32_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				v			= 0;
				
				WinPE32TreeTableRecord IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(IMPORT_ADDRESS_TABLE);
//				IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	DWORD	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		+= beforesize;
				size	= DWORD;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";			
				v	= getStringToInt(value, false);			
				if((v & 0x80000000) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(v & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= IMPORT_ADDRESS_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();
					}
					notes		= IMPORT_ADDRESS_TABLEAddressOfDataNotes;		
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);
				
				
				//IMAGE_IMPORT_BY_NAME作成			
				if((v & 0x80000000) == 0 && !value.equals("00000000")) { //AddressOfDataなら					
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					int maxAddress	= lastLineno*16+lastByteNum;
					
					if(v<maxAddress){
						makeImageImportByName(recordItem, value, String.format("%08X", v).toUpperCase());
					}else{
						record.setCheck("*");
					}
				}
				
				count++;
				
			}while(!value.equals("00000000"));

					
		}else if(magicNumber.equals("020B")){	//PE32+
			
			dataSize	= IMAGE_THUNK_DATA64_SIZE;
			
			do{
				//IMPORT_ADDRESS_TABLE
				name		= "IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA64_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				
				WinPE32TreeTableRecord IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(IMPORT_ADDRESS_TABLE);
//				IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	ULONGLONG	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		= rva + beforesize;
				size	= ULONGLONG;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";
				vl	= getStringToLong(value, false);			
				if((vl & Long.MIN_VALUE) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(vl & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= IMPORT_ADDRESS_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(vl != 0){
						vl -= addrDiff;
						analysis	= "Raw=0x" + String.format("%016X", vl).toUpperCase();
					}
					notes		= IMPORT_ADDRESS_TABLEAddressOfDataNotes;
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);	
				
				//IMAGE_IMPORT_BY_NAME作成			
				if((vl & Long.MIN_VALUE) == 0 && !value.equals("0000000000000000")) { //Ordinalなら					
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					long maxAddress	= lastLineno*16+lastByteNum;
					
					if(vl<maxAddress){
						makeImageImportByName(recordItem, value.substring(8, 16), String.format("%08X", vl).toUpperCase());
					}else{
						record.setCheck("*");
					}		
				}				
				
				count++;	
				
			}while(!value.equals("0000000000000000"));
				
		}
		
		return count;
	}
	
	private void makeImageResourceDirectory(TreeItem<WinPE32TreeTableRecord> item) {
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
				
		//カウント
		int count		= 0;
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;
		
		//各エントリー数
		int numNameEntry		= 0;
		int numIdEntry			= 0;
		
		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA, IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA, false)-addrDiff;

					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;				

					
					do{
						//IMAGE_RESOURCE_DIRECTORY		
						name		= "IMAGE_RESOURCE_DIRECTORY"+"["+count+"]";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= IMAGE_RESOURCE_DIRECTORY_SIZE;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_RESOURCE_DIRECTORYNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_RESOURCE_DIRECTORY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_RESOURCE_DIRECTORYItem 	= new TreeItem<>(IMAGE_RESOURCE_DIRECTORY);
//						IMAGE_RESOURCE_DIRECTORYItem.setExpanded(true);
						item.getChildren().add(IMAGE_RESOURCE_DIRECTORYItem);
					
					
						//0x00	DWORD	Characteristics
						name	= "Characteristics";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_RESOURCE_DIRECTORYCharacteristicsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//						CharacteristicsItem.setExpanded(true);
						IMAGE_RESOURCE_DIRECTORYItem.getChildren().add(CharacteristicsItem);

						
						//0x04	DWORD	TimeDateStamp
						name	= "TimeDateStamp";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						Date date 	= new Date(Long.parseLong(value, 16)*1000);
						analysis	= date.toString();	
						notes		= IMAGE_RESOURCE_DIRECTORYTimeDateStampNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord TimeDateStamp				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> TimeDateStampItem	= new TreeItem<>(TimeDateStamp);
//						TimeDateStampItem.setExpanded(true);
						IMAGE_RESOURCE_DIRECTORYItem.getChildren().add(TimeDateStampItem);
						
						
						//0x08	WORD	MajorVersion
						name	= "MajorVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_RESOURCE_DIRECTORYMajorVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MajorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MajorVersionItem	= new TreeItem<>(MajorVersion);
//						MajorVersionItem.setExpanded(true);
						IMAGE_RESOURCE_DIRECTORYItem.getChildren().add(MajorVersionItem);					
						
						
						//0x0A	WORD	MinorVersion
						name	= "MinorVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_RESOURCE_DIRECTORYMinorVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MinorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MinorVersionItem	= new TreeItem<>(MinorVersion);
//						MinorVersionItem.setExpanded(true);
						IMAGE_RESOURCE_DIRECTORYItem.getChildren().add(MinorVersionItem);					
						
						
						//0x0C	WORD	NumberOfNameEntries
						name	= "NumberOfNameEntries";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= Integer.toString(v);
						notes		= IMAGE_RESOURCE_DIRECTORYNumberOfNameEntriesNotes;
						beforesize	= size;
						numNameEntry	= v;
						
						WinPE32TreeTableRecord NumberOfNameEntries					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> NumberOfNameEntriesItem	= new TreeItem<>(NumberOfNameEntries);
//						NumberOfNameEntriesItem.setExpanded(true);
						IMAGE_RESOURCE_DIRECTORYItem.getChildren().add(NumberOfNameEntriesItem);			
						
						
						//0x0E	WORD	NumberOfIdEntries
						name	= "NumberOfIdEntries";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= Integer.toString(v);
						notes		= IMAGE_RESOURCE_DIRECTORYNumberOfIdEntriesNotes;
						beforesize	= size;
						numIdEntry	= v;
						
						WinPE32TreeTableRecord NumberOfIdEntries				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> NumberOfIdEntriesItem	= new TreeItem<>(NumberOfIdEntries);
//						NumberOfIdEntriesItem.setExpanded(true);
						IMAGE_RESOURCE_DIRECTORYItem.getChildren().add(NumberOfIdEntriesItem);		
								
									
						//RESOURCE_DIRECTORY_ENTRY作成					
						for(int i=0; i<numNameEntry+numIdEntry;i++){								
							//RESOURCE_DIRECTORY_ENTRY
							name		= "RESOURCE_DIRECTORY_ENTRY"+"["+i+"]";
							rawAddr		+= beforesize;
							raw			= rawAddr;
							offset		+= beforesize;
							rva			= startSectionRVA + offset;
							size		= RESOURCE_DIRECTORY_ENTRY_SIZE;
							value		= "";
							analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
							notes		= RESOURCE_DIRECTORY_ENTRYNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord RESOURCE_DIRECTORY_ENTRY				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
							TreeItem<WinPE32TreeTableRecord> RESOURCE_DIRECTORY_ENTRYItem 	= new TreeItem<>(RESOURCE_DIRECTORY_ENTRY);
//							RESOURCE_DIRECTORY_ENTRYItem.setExpanded(true);
							IMAGE_RESOURCE_DIRECTORYItem.getChildren().add(RESOURCE_DIRECTORY_ENTRYItem);
									
							//RESOURCE_DIRECTORY_ENTRY作成
							makeResourceDirectoryEntry(RESOURCE_DIRECTORY_ENTRYItem, String.format("%08X", rva).toUpperCase(), String.format("%08X", raw).toUpperCase(), IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA, String.format("%08X", getStringToInt(IMAGE_DIRECTORY_ENTRY_RESOURCE_RVA, false)-addrDiff).toUpperCase());
							
						}
						
						count++;
						
						//次のデータを調べる
						size	= DWORD;
						value	= "";
						for(int i=offset+beforesize+size-1; i>=offset+beforesize; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						
					}while(value.equals("00000000"));	//次のデータが00000000（Characteristics）なら、ループ

				}
			}
		}
	}	
	
	private void makeResourceDirectoryEntry(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr, String ResourceDirectoryStartRVAAddr, String ResourceDirectoryStartRawAddr){
			
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= startRawAddr;
		int raw			= 0;
		int rva			= startRVA;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		
		//データ取得
		dataSize	= RESOURCE_DIRECTORY_ENTRY_SIZE;
		data		= getBintableBytes(rawAddr, dataSize);	
		
		//NameRVA用
		boolean	nameRVAFlag	= false;
		int nameOffset		= 0;
		
		//DataEntryRVA用
		boolean dataEntryRVAFlag	= false;
		int	offsetToData			= 0;
	
		//0x00	DWORD	Name/ID
		name	= "";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	+= beforesize;
		rva		+= beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";			
		v	= getStringToInt(value, false);	
		if((v & 0x80000000) != 0){	//Nameが存在すれば
			name		= "NameRVA";
			analysis	= "NameOffset=0x" + String.format("%08X", v&0x7FFFFFFF).toUpperCase();
			notes		= RESOURCE_DIRECTORY_ENTRYNameRVANotes;
			
			//nameRVAFlagをtrueにする
			nameRVAFlag	= true;
			nameOffset	= v&0x7FFFFFFF;			
		}else{
			name		= "ID";
			analysis	= "ID="+v;
			notes		= RESOURCE_DIRECTORY_ENTRYIDNotes;
		}			
		beforesize	= size;
		
		WinPE32TreeTableRecord NameID				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> NameIDItem	= new TreeItem<>(NameID);
//		NameIDItem.setExpanded(true);
		item.getChildren().add(NameIDItem);


		//0x04	DWORD	DataEntryRVA/SubdirectoryRVA
		name	= "";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	+= beforesize;
		rva		+= beforesize;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";			
		v	= getStringToInt(value, false);			
		if((v & 0x80000000) != 0){	//SubdirectoryRVAなら
			name		= "SubdirectoryRVA";
			analysis	= "OffsetToDirectory=0x"+String.format("%08X", v & 0x7FFFFFFF).toUpperCase();	//The lower 32bits are address of another resource directory table
			notes		= RESOURCE_DIRECTORY_ENTRYSubdirectoryRVANotes;
			
		}else{	//DataEntryRVAなら
			name		= "DataEntryRVA";
			analysis	= "OffsetToData=0x"+String.format("%08X", v).toUpperCase();
			notes		= RESOURCE_DIRECTORY_ENTRYDataEntryRVANotes;
			
			//dataEntryRVAFlagをtrueにする
			dataEntryRVAFlag	= true;
			offsetToData		= v;		
		}
		beforesize	= size;
		
		WinPE32TreeTableRecord DataEntryRVASubdirectoryRVA					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> DataEntryRVASubdirectoryRVAItem	= new TreeItem<>(DataEntryRVASubdirectoryRVA);
//		DataEntryRVASubdirectoryRVAItem.setExpanded(true);
		item.getChildren().add(DataEntryRVASubdirectoryRVAItem);
		
		
		//NameRVAなら、RESOURCE_DIRECTRY_STRING作成
		if(nameRVAFlag){
			//RESOURCE_DIRECTRY_STRING作成		
			name		= "RESOURCE_DIRECTRY_STRING";
			offset		= nameOffset;
			rawAddr		= getStringToInt(ResourceDirectoryStartRawAddr, false)+offset;
			raw			= rawAddr;
			rva			= getStringToInt(ResourceDirectoryStartRVAAddr, false)+offset;
			size		= 0;
			value		= "";
			analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
			notes		= RESOURCE_DIRECTRY_STRINGNotes;
			beforesize	= 0;
			
			WinPE32TreeTableRecord RESOURCE_DIRECTRY_STRING					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<WinPE32TreeTableRecord> RESOURCE_DIRECTRY_STRINGItem 	= new TreeItem<>(RESOURCE_DIRECTRY_STRING);
//			RESOURCE_DIRECTRY_STRINGItem.setExpanded(true);
			NameIDItem.getChildren().add(RESOURCE_DIRECTRY_STRINGItem);

			makeResourceDirectoryString(RESOURCE_DIRECTRY_STRINGItem, String.format("%08X", rva).toUpperCase(), String.format("%08X", raw).toUpperCase());

		}
		
		//DataEntryRVAなら、RESOURCE_DATA_ENTRY作成
		if(dataEntryRVAFlag){
			//RESOURCE_DATA_ENTRY作成			
			name		= "RESOURCE_DATA_ENTRY";
			offset		= offsetToData;
			rawAddr		= getStringToInt(ResourceDirectoryStartRawAddr, false)+offset;
			raw			= rawAddr;
			rva			= getStringToInt(ResourceDirectoryStartRVAAddr, false)+offset;
			size		= RESOURCE_DATA_ENTRY_SIZE;
			value		= "";
			analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
			notes		= RESOURCE_DATA_ENTRYNotes;
			beforesize	= 0;
			
			WinPE32TreeTableRecord RESOURCE_DATA_ENTRY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
			TreeItem<WinPE32TreeTableRecord> RESOURCE_DATA_ENTRYItem 	= new TreeItem<>(RESOURCE_DATA_ENTRY);
//			RESOURCE_DATA_ENTRYItem.setExpanded(true);
			DataEntryRVASubdirectoryRVAItem.getChildren().add(RESOURCE_DATA_ENTRYItem);

			makeResourceDataEntry(RESOURCE_DATA_ENTRYItem, String.format("%08X", rva).toUpperCase(), String.format("%08X", raw).toUpperCase());
			
		}
		
	}

	private void makeResourceDirectoryString(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= 0;
		int raw			= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		
		//文字列の長さ
		int stringLenght	= 0;
	
		//データ取得
		dataSize	= WORD;
		data		= getBintableBytes(startRawAddr, dataSize);		
		
		
		//0x00	WORD	Length
		name	= "Length";
		rawAddr	= startRawAddr;
		raw		= rawAddr;
		offset	+= beforesize;
		rva		= startRVA + offset;
		size	= WORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis		= "";			
		v				= getStringToInt(value, false);
		stringLenght	= v;
		analysis		= Integer.toString(v)+" charactors";
		notes			= RESOURCE_DIRECTRY_STRINGLengthNotes;
		beforesize		= size;
		
		WinPE32TreeTableRecord Length				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> LengthItem	= new TreeItem<>(Length);
//		LengthItem.setExpanded(true);
		item.getChildren().add(LengthItem);
		
		//データ再取得
		dataSize	= WORD+stringLenght*WORD;
		data		= getBintableBytes(startRawAddr, dataSize);	

		
		//0x04	variable	UnicodeString
		name		= "UnicodeString";
		rawAddr		+= beforesize;
		raw			= rawAddr;
		offset		+= beforesize;
		rva			= startRVA + offset;
		size		= stringLenght * WORD;
		value		= "";
		analysis	= "";	
		for(int i=offset+size-1; i>=offset; i-- ){
			value		+= String.format("%02X", data[i]).toUpperCase();
		}
		for(int i=offset-1; i<offset+size; i++){
			analysis	+= String.format("%c", data[i]);
		}
		notes				= RESOURCE_DIRECTRY_STRINGUnicodeStringNotes;
		beforesize			= size;
		
		WinPE32TreeTableRecord UnicodeString				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> UnicodeStringItem	= new TreeItem<>(UnicodeString);
//		UnicodeStringItem.setExpanded(true);
		item.getChildren().add(UnicodeStringItem);

	}
	
	private void makeResourceDataEntry(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= 0;
		int raw			= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		
		//データ取得
		dataSize	= RESOURCE_DATA_ENTRY_SIZE;
		data		= getBintableBytes(startRawAddr, dataSize);			

		//
		int resourceDataAddr	= 0;
		int resourceDataSize	= 0;
		
	
		//0x00	DWORD	DataRVA
		name	= "DataRVA";
		rawAddr	= startRawAddr;
		raw		= rawAddr;
		offset	+= beforesize;
		rva		= startRVA + offset;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis			= "";			
		v					= getStringToInt(value, false);
		resourceDataAddr	= v;
		if(v != 0){
			v -= addrDiff;
			analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();
		}
		notes		= RESOURCE_DATA_ENTRYDataRVANotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord DataRVA					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> DataRVAItem	= new TreeItem<>(DataRVA);
//		DataRVAItem.setExpanded(true);
		item.getChildren().add(DataRVAItem);
		
		
		//0x04	DWORD	Size
		name	= "Size";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	+= beforesize;
		rva		= startRVA + offset;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis			= "";			
		v					= getStringToInt(value, false);
		resourceDataSize	= v;
		analysis			= Integer.toString(v)+" bytes";
		notes				= RESOURCE_DATA_ENTRYSizeNotes;
		beforesize			= size;
		
		WinPE32TreeTableRecord Size					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> SizeItem	= new TreeItem<>(Size);
//		SizeItem.setExpanded(true);
		item.getChildren().add(SizeItem);
		
		
		//0x08	DWORD	CodePage
		name	= "CodePage";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	+= beforesize;
		rva		= startRVA + offset;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";
		notes		= RESOURCE_DATA_ENTRYCodePageNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord CodePage					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> CodePageItem	= new TreeItem<>(CodePage);
//		CodePageItem.setExpanded(true);
		item.getChildren().add(CodePageItem);
		
		
		//0x0C	DWORD	Reserved
		name	= "Reserved";
		rawAddr	+= beforesize;
		raw		= rawAddr;
		offset	+= beforesize;
		rva		= startRVA + offset;
		size	= DWORD;
		value	= "";
		for(int i=offset+size-1; i>=offset; i-- ){
			value	+= String.format("%02X", data[i]).toUpperCase();
		}
		analysis	= "";			
		notes		= RESOURCE_DATA_ENTRYReservedNotes;
		beforesize	= size;
		
		WinPE32TreeTableRecord Reserved					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> ReservedItem	= new TreeItem<>(Reserved);
//		DataRVAItem.setExpanded(true);
		item.getChildren().add(ReservedItem);
	
		
		//RESOURCE_DATA作成
		name		= "RESOURCE_DATA";
		rva			= resourceDataAddr;
		rawAddr		= rva-addrDiff;
		raw			= rawAddr;
		offset		= 0x0;				
		size		= resourceDataSize;
		value		= "";
		analysis	= "";
		notes		= RESOURCE_DATANotes;
		beforesize	= 0;
		
		WinPE32TreeTableRecord RESOURCE_DATA				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
		TreeItem<WinPE32TreeTableRecord> RESOURCE_DATAItem 	= new TreeItem<>(RESOURCE_DATA);
//		RESOURCE_DATAItem.setExpanded(true);
		DataRVAItem.getChildren().add(RESOURCE_DATAItem);
		
	}
	
	private void makeImageRuntimeFunctionEntry(TreeItem<WinPE32TreeTableRecord> item) {
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//カウント
		int count = 0;
		int sizeCount	= 0;
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;

		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA, IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;


					while(sizeCount<IMAGE_DIRECTORY_ENTRY_EXCEPTION_RVA_SIZE){
					
						if(targetPlatform.equals("0166")){	// MIPS little endian
							
							//FUNCTION_TABLE_ENTRY
							name		= "FUNCTION_TABLE_ENTRY(MIPS32bit)"+"["+count+"]";
							rawAddr		+= beforesize;
							raw			= rawAddr;
							offset		+= beforesize;
							rva			= startSectionRVA + offset;
							size		= IMAGE_ALPHA_RUNTIME_FUNCTION_ENTRY_SIZE;
							value		= "";
							analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
							notes		= FUNCTION_TABLE_ENTRY_MIPS32Notes;
							beforesize	= 0;
							baseOffset	= offset;
							
							WinPE32TreeTableRecord FUNCTION_TABLE_ENTRY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
							TreeItem<WinPE32TreeTableRecord> FUNCTION_TABLE_ENTRYItem 	= new TreeItem<>(FUNCTION_TABLE_ENTRY);
//							FUNCTION_TABLE_ENTRYItem.setExpanded(true);
							item.getChildren().add(FUNCTION_TABLE_ENTRYItem);
						
						
							//0x00	DWORD	BeginAddress
							name	= "BeginAddress";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_MIPS32BeginAddressNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord BeginAddress					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> BeginAddressItem	= new TreeItem<>(BeginAddress);
//							BeginAddressItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(BeginAddressItem);

							
							//0x04	DWORD	EndAddress
							name	= "EndAddress";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_MIPS32EndAddressNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord EndAddress					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> EndAddressItem	= new TreeItem<>(EndAddress);
//							EndAddressItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(EndAddressItem);

							
							//0x08	DWORD	ExceptionHandler
							name	= "ExceptionHandler";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_MIPS32ExceptionHandlerNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord ExceptionHandler					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> ExceptionHandlerItem	= new TreeItem<>(ExceptionHandler);
//							ExceptionHandlerItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(ExceptionHandlerItem);

							
							//0x0C	DWORD	HandlerData
							name	= "HandlerData";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_MIPS32HandlerDataNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord HandlerData					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> HandlerDataItem	= new TreeItem<>(HandlerData);
//							HandlerDataItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(HandlerDataItem);

							
							//0x10	DWORD	PrologEndAddress
							name	= "PrologEndAddress";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_MIPS32PrologEndAddressNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord PrologEndAddress					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> PrologEndAddressItem	= new TreeItem<>(PrologEndAddress);
//							PrologEndAddressItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(PrologEndAddressItem);

							//サイズ
							sizeCount	+=	IMAGE_ALPHA_RUNTIME_FUNCTION_ENTRY_SIZE;
							
						}else if(targetPlatform.equals("01C0") ||	//ARM little endian
								 targetPlatform.equals("01F0") ||	//Power PC little endian
								 targetPlatform.equals("01A2") ||	//Hitachi SH3
								 targetPlatform.equals("01A6")){	//Hitachi SH4
							
							//FUNCTION_TABLE_ENTRY
							name		= "FUNCTION_TABLE_ENTRY(WindowsCE)"+"["+count+"]";
							rawAddr		+= beforesize;
							raw			= rawAddr;
							offset		+= beforesize;
							rva			= startSectionRVA + offset;
							size		= IMAGE_CE_RUNTIME_FUNCTION_ENTRY_SIZE;
							value		= "";
							analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
							notes		= FUNCTION_TABLE_ENTRY_CENotes;
							beforesize	= 0;
							baseOffset	= offset;
							
							WinPE32TreeTableRecord FUNCTION_TABLE_ENTRY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
							TreeItem<WinPE32TreeTableRecord> FUNCTION_TABLE_ENTRYItem 	= new TreeItem<>(FUNCTION_TABLE_ENTRY);
//							FUNCTION_TABLE_ENTRYItem.setExpanded(true);
							item.getChildren().add(FUNCTION_TABLE_ENTRYItem);
						
						
							//0x00	DWORD	BeginAddress
							name	= "BeginAddress";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_CEBeginAddressNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord BeginAddress					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> BeginAddressItem	= new TreeItem<>(BeginAddress);
//							BeginAddressItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(BeginAddressItem);

							
							//0x04	8bits	PrologLength
							name	= "PrologLength";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= BYTE;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_CEPrologLengthNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord PrologLength					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> PrologLengthItem	= new TreeItem<>(PrologLength);
//							PrologLengthItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(PrologLengthItem);

							
							//0x05	22bits	FunctionLength
							name	= "FunctionLength";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= BYTE*3;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								if(i==offset+size-1){
									value	+= String.format("%02X", data[i]&0xC).toUpperCase();
								}else{
									value	+= String.format("%02X", data[i]).toUpperCase();
								}
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_CEFunctionLengthNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord FunctionLength				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> FunctionLengthItem	= new TreeItem<>(FunctionLength);
//							FunctionLengthItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(FunctionLengthItem);							
							
							
							//0x07	1bit	32-bitFlag
							name	= "32-bitFlag";
							value	= "";
							value	= String.format("%01X", data[offset+size-1]&0x2).toUpperCase();
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_CEbitFlagNotes;
							
							WinPE32TreeTableRecord bitFlag					= new WinPE32TreeTableRecord(name, String.format("%08X", raw+2).toUpperCase(), String.format("%08X", rva+2).toUpperCase(), String.format("%08X", offset-baseOffset+2).toUpperCase(), String.format("%08X", BYTE).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> bitFlagItem	= new TreeItem<>(bitFlag);
//							bitFlagItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(bitFlagItem);							
							
							
							//0x07	1bit	ExceptionFlag
							name	= "ExceptionFlag";
							value	= "";
							value	= String.format("%01X", data[offset+size-1]&0x1).toUpperCase();
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_CEExceptionFlagNotes;
							
							WinPE32TreeTableRecord ExceptionFlag				= new WinPE32TreeTableRecord(name, String.format("%08X", raw+2).toUpperCase(), String.format("%08X", rva+2).toUpperCase(), String.format("%08X", offset-baseOffset+2).toUpperCase(), String.format("%08X", BYTE).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> ExceptionFlagItem	= new TreeItem<>(ExceptionFlag);
//							ExceptionFlagItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(ExceptionFlagItem);							
							
							//サイズ
							sizeCount	+=	IMAGE_CE_RUNTIME_FUNCTION_ENTRY_SIZE;
									
						}else if(targetPlatform.equals("8664") || 	//x64
								 targetPlatform.equals("0200")){	//Intel Itanium processor family
							
							//FUNCTION_TABLE_ENTRY
							name		= "FUNCTION_TABLE_ENTRY(x64)"+"["+count+"]";
							rawAddr		+= beforesize;
							raw			= rawAddr;
							offset		+= beforesize;
							rva			= startSectionRVA + offset;
							size		= IMAGE_RUNTIME_FUNCTION_ENTRY_SIZE;
							value		= "";
							analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
							notes		= FUNCTION_TABLE_ENTRY_x64Notes;
							beforesize	= 0;
							baseOffset	= offset;
							
							WinPE32TreeTableRecord FUNCTION_TABLE_ENTRY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
							TreeItem<WinPE32TreeTableRecord> FUNCTION_TABLE_ENTRYItem 	= new TreeItem<>(FUNCTION_TABLE_ENTRY);
//							FUNCTION_TABLE_ENTRYItem.setExpanded(true);
							item.getChildren().add(FUNCTION_TABLE_ENTRYItem);
						
						
							//0x00	DWORD	BeginAddress
							name	= "BeginAddress";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_x64BeginAddressNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord BeginAddress					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> BeginAddressItem	= new TreeItem<>(BeginAddress);
//							BeginAddressItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(BeginAddressItem);

							
							//0x04	DWORD	EndAddress
							name	= "EndAddress";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_x64EndAddressNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord EndAddress					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> EndAddressItem	= new TreeItem<>(EndAddress);
//							EndAddressItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(EndAddressItem);

							
							//0x08	DWORD	UnwindInformation
							name	= "UnwindInformation";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_x64UnwindInformationNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord UnwindInformation					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> UnwindInformationItem	= new TreeItem<>(UnwindInformation);
//							UnwindInformationItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(UnwindInformationItem);
													
							//サイズ
							sizeCount	+=	IMAGE_RUNTIME_FUNCTION_ENTRY_SIZE;
							
						}else if(targetPlatform.equals("01C4")){	//ARMv7 (or higher) Thumb mode only
							
							//FUNCTION_TABLE_ENTRY
							name		= "FUNCTION_TABLE_ENTRY(ARMv7)"+"["+count+"]";
							rawAddr		+= beforesize;
							raw			= rawAddr;
							offset		+= beforesize;
							rva			= startSectionRVA + offset;
							size		= IMAGE_ARMV7_RUNTIME_FUNCTION_ENTRY_SIZE;
							value		= "";
							analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
							notes		= FUNCTION_TABLE_ENTRY_ARMV7Notes;
							beforesize	= 0;
							baseOffset	= offset;
							
							WinPE32TreeTableRecord FUNCTION_TABLE_ENTRY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
							TreeItem<WinPE32TreeTableRecord> FUNCTION_TABLE_ENTRYItem 	= new TreeItem<>(FUNCTION_TABLE_ENTRY);
//							FUNCTION_TABLE_ENTRYItem.setExpanded(true);
							item.getChildren().add(FUNCTION_TABLE_ENTRYItem);
						
						
							//0x00	DWORD	BeginAddress
							name	= "BeginAddress";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_ARMV7BeginAddressNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord BeginAddress					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> BeginAddressItem	= new TreeItem<>(BeginAddress);
//							BeginAddressItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(BeginAddressItem);

							
							//0x04	DWORD	UnwindInformation
							name	= "UnwindInformation";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";					
							notes		= FUNCTION_TABLE_ENTRY_ARMV7UnwindInformationNotes;
							beforesize	= size;
							
							WinPE32TreeTableRecord UnwindInformation				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> UnwindInformationItem	= new TreeItem<>(UnwindInformation);
//							UnwindInformationItem.setExpanded(true);
							FUNCTION_TABLE_ENTRYItem.getChildren().add(UnwindInformationItem);

							//サイズ
							sizeCount	+= IMAGE_ARMV7_RUNTIME_FUNCTION_ENTRY_SIZE;
								
						}else{
							
							//他の場合はなにもしない
							break;
							
						}

						count++;

					}
				}
			}
		}
	}
	
	private void makeAttributeCertificateEntry(TreeItem<WinPE32TreeTableRecord> item) {
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//カウント
		int count = 0;
		int sizeCount	= 0;
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;

		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_SECURITY_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_SECURITY_RVA_SIZE!=0) {
						
			//残りデータはあるか？
			if(!remainingDataRawAddr.equals("00000000") && reaminingDataRawSize!=0){
				
				//残りデータにデータがあれば作る
				if(getStringToInt(IMAGE_DIRECTORY_ENTRY_SECURITY_RVA, false)>=getStringToInt(remainingDataRawAddr, false) &&
				   getStringToInt(IMAGE_DIRECTORY_ENTRY_SECURITY_RVA, false)+IMAGE_DIRECTORY_ENTRY_SECURITY_RVA_SIZE <= getStringToInt(remainingDataRawAddr, false)+reaminingDataRawSize){
					
//					System.out.println(remainingDataRawAddr);
//					System.out.println(reaminingDataRawSize);
					
					//残りデータ取得
					data		= getBintableBytes(getStringToInt(remainingDataRawAddr, false), reaminingDataRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_SECURITY_RVA, false);
					
					//データオフセット設定
					offset		= rawAddr - getStringToInt(remainingDataRawAddr, false);
					startOffset	= offset;
					beforesize	= 0;


					while(sizeCount<IMAGE_DIRECTORY_ENTRY_SECURITY_RVA_SIZE){
	
						//ATTRIBUTE_CERTIFICATE_ENTRY
						name		= "ATTRIBUTE_CERTIFICATE_ENTRY"+"["+count+"]";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						size		= 0;
						value		= "";
						analysis	= "Data=REMAINING_DATA";
						notes		= ATTRIBUTE_CERTIFICATE_ENTRYNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord ATTRIBUTE_CERTIFICATE_ENTRY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> ATTRIBUTE_CERTIFICATE_ENTRYItem 	= new TreeItem<>(ATTRIBUTE_CERTIFICATE_ENTRY);
//						ATTRIBUTE_CERTIFICATE_ENTRYItem.setExpanded(true);
						item.getChildren().add(ATTRIBUTE_CERTIFICATE_ENTRYItem);
						
						
						//0x00	DWORD	dwLength
						name	= "dwLength";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v)+" bytes";
						notes		= ATTRIBUTE_CERTIFICATE_ENTRYdwLengthNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord dwLength					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> dwLengthItem	= new TreeItem<>(dwLength);
//						dwLengthItem.setExpanded(true);
						ATTRIBUTE_CERTIFICATE_ENTRYItem.getChildren().add(dwLengthItem);
						
						//サイズ更新
						ATTRIBUTE_CERTIFICATE_ENTRY.setSize(value);
						
						
						//0x04	WORD	wRevision
						name	= "wRevision";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						if(value.equals("0100")){
							analysis	= "WIN_CERT_REVISION_1_0(0x0100)";
						}else if(value.equals("0200")){
							analysis	= "WIN_CERT_REVISION_2_0(0x0200)";
						}
						notes		= ATTRIBUTE_CERTIFICATE_ENTRYwRevisionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord wRevision				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> wRevisionItem	= new TreeItem<>(wRevision);
//						wRevisionItem.setExpanded(true);
						ATTRIBUTE_CERTIFICATE_ENTRYItem.getChildren().add(wRevisionItem);
						
						
						//0x06	WORD	wCertificateType
						name	= "wCertificateType";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						if(value.equals("0001")){
							analysis	= "WIN_CERT_TYPE_X509(0x0001)";
						}else if(value.equals("0002")){
							analysis	= "WIN_CERT_TYPE_PKCS_SIGNED_DATA(0x0002)";
						}else if(value.equals("0003")){
							analysis	= "WIN_CERT_TYPE_RESERVED_1(0x0003)";
						}else if(value.equals("0004")){
							analysis	= "WIN_CERT_TYPE_TS_STACK_SIGNED(0x0004)";
						}
						notes		= ATTRIBUTE_CERTIFICATE_ENTRYwCertificateTypeNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord wCertificateType					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> wCertificateTypeItem	= new TreeItem<>(wCertificateType);
//						wCertificateTypeItem.setExpanded(true);
						ATTRIBUTE_CERTIFICATE_ENTRYItem.getChildren().add(wCertificateTypeItem);						
						
						
						//0x08	variable	bCertificate
						name	= "bCertificate";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						size	= getStringToInt(ATTRIBUTE_CERTIFICATE_ENTRY.getSize(), false)-(DWORD+WORD*2);
						value	= "";
						analysis	= "";					
						notes		= ATTRIBUTE_CERTIFICATE_ENTRYbCertificateNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord bCertificate					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> bCertificateItem	= new TreeItem<>(bCertificate);
//						bCertificateItem.setExpanded(true);
						ATTRIBUTE_CERTIFICATE_ENTRYItem.getChildren().add(bCertificateItem);	
						
						
						//サイズ加算
						sizeCount	+= getStringToInt(ATTRIBUTE_CERTIFICATE_ENTRY.getSize(), false);

					}
				}
			}
		}
	}
	
	private void makeImageBaseRelocation(TreeItem<WinPE32TreeTableRecord> item) {
	
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		int virtualaddress	= 0;
		int blocksize	= 0;
		
		//カウント
		int count		= 0;
		int sizeCount	= 0;
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;		
		
		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA, IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;	
					
					
					while(sizeCount<IMAGE_DIRECTORY_ENTRY_BASERELOC_RVA_SIZE){
						
						//IMAGE_BASE_RELOCATION			
						name		= "IMAGE_BASE_RELOCATION"+"["+count+"]";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= 0;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_BASE_RELOCATIONNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_BASE_RELOCATION				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_BASE_RELOCATIONItem 	= new TreeItem<>(IMAGE_BASE_RELOCATION);
//						IMAGE_BASE_RELOCATIONItem.setExpanded(true);
						item.getChildren().add(IMAGE_BASE_RELOCATIONItem);
											
				
						//0x00	DWORD	VirtualAddress
						name	= "VirtualAddress";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						virtualaddress	= v;
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x"+String.format("%08X", v).toUpperCase();		
						}						
						notes		= BASE_RELOCATION_BLOCKVirtualAddressNotes;
						beforesize	= size;
						
						//サイズ加算
						sizeCount	+= DWORD;
						
						WinPE32TreeTableRecord VirtualAddress				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> VirtualAddressItem	= new TreeItem<>(VirtualAddress);
//						VirtualAddressItem.setExpanded(true);
						IMAGE_BASE_RELOCATIONItem.getChildren().add(VirtualAddressItem);

						
						//0x04	DWORD	SizeOfBlock
						name	= "SizeOfBlock";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= Integer.toString(v)+" bytes";
						notes		= BASE_RELOCATION_BLOCKSizeOfBlockNotes;
						beforesize	= size;
						blocksize	= v;
						
						//サイズ加算
						sizeCount	+= DWORD;
						
						WinPE32TreeTableRecord SizeOfBlock					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SizeOfBlockItem	= new TreeItem<>(SizeOfBlock);
//						SizeOfBlockItem.setExpanded(true);
						IMAGE_BASE_RELOCATIONItem.getChildren().add(SizeOfBlockItem);					
											
						//IMAGE_BASE_RELOCATIONサイズ更新
						IMAGE_BASE_RELOCATION.setSize(String.format("%08X", blocksize).toUpperCase());
						
						
						//TypeOffset
						name		= "TypeOffset";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= blocksize-DWORD*2;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= BASE_RELOCATION_BLOCKTypeOffsetNotes;
						beforesize	= 0;
						
						WinPE32TreeTableRecord TypeOffset				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> TypeOffsetItem 	= new TreeItem<>(TypeOffset);
//						TypeOffsetItem.setExpanded(true);
						IMAGE_BASE_RELOCATIONItem.getChildren().add(TypeOffsetItem);	
						
						for(int s=0;s*WORD<blocksize-DWORD*2;s++){
							
							//WORD	TypeOffsetRecord
							name	= "TypeOffset"+"["+s+"]";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= startSectionRVA + offset;
							size	= WORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";
							String t	= value.substring(0, 1);
							String o	= "0"+value.substring(1, 4);	
							
							if(t.equals("0")){
								analysis	= "Type=IMAGE_REL_BASED_ABSOLUTE(0x0)\n";
							}else if(t.equals("1")){
								analysis	= "Type=IMAGE_REL_BASED_HIGH(0x1)\n";
							}else if(t.equals("2")){
								analysis	= "Type=IMAGE_REL_BASED_LOW(0x2)\n";
							}else if(t.equals("3")){
								analysis	= "Type=IMAGE_REL_BASED_HIGHLOW(0x3)\n";
							}else if(t.equals("4")){
								analysis	= "Type=IMAGE_REL_BASED_HIGHADJ(0x4)\n";
							}else if(t.equals("5")){
								analysis	= "Type=IMAGE_REL_BASED_MIPS_JMPADDR(0x5), IMAGE_REL_BASED_ARM_MOV32A(0x5)\n";
							}else if(t.equals("7")){
								analysis	= "Type=IMAGE_REL_BASED_ARM_MOV32T(0x7)\n";
							}else if(t.equals("9")){
								analysis	= "Type=IMAGE_REL_BASED_MIPS_JMPADDR16(0x9)\n";
							}else if(t.equals("A")){
								analysis	= "Type=IMAGE_REL_BASED_DIR64(0xA)\n";
							}						
							v			= getStringToInt(o, false);
							analysis	+= "Offset=0x"+String.format("%03X", v).toUpperCase()+"\n";	
							analysis	+= "VirtualAddress+Offset=0x"+String.format("%08X", virtualaddress+v).toUpperCase();
							notes		= BASE_RELOCATION_BLOCKTypeOffsetNotes;
							beforesize	= size;
							
							//サイズ加算
							sizeCount	+= WORD;
							
							WinPE32TreeTableRecord TypeOffsetRecord					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> TypeOffsetRecordItem	= new TreeItem<>(TypeOffsetRecord);
//							TypeOffsetRecordItem.setExpanded(true);
							TypeOffsetItem.getChildren().add(TypeOffsetRecordItem);

						}
						
						//カウント
						count++;
					}
				}
			}
		}
	}
	
	private void makeImageDebugDirectoty(TreeItem<WinPE32TreeTableRecord> item) {
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;
		
		//
		int debugDataSize	= 0;
		
		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_DEBUG_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_DEBUG_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_DEBUG_RVA, IMAGE_DIRECTORY_ENTRY_DEBUG_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_DEBUG_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;

					
					//IMAGE_DEBUG_DIRECTRY		
					name		= "IMAGE_DEBUG_DIRECTRY";
					rawAddr		+= beforesize;
					raw			= rawAddr;
					offset		+= beforesize;
					rva			= startSectionRVA + offset;
					size		= IMAGE_DEBUG_DIRECTRY_SIZE;
					value		= "";
					analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
					notes		= IMAGE_DEBUG_DIRECTRYNotes;
					beforesize	= 0;
					baseOffset	= offset;
					
					WinPE32TreeTableRecord IMAGE_DEBUG_DIRECTRY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
					TreeItem<WinPE32TreeTableRecord> IMAGE_DEBUG_DIRECTRYItem 	= new TreeItem<>(IMAGE_DEBUG_DIRECTRY);
//					IMAGE_DEBUG_DIRECTRYItem.setExpanded(true);
					item.getChildren().add(IMAGE_DEBUG_DIRECTRYItem);
				
				
					//0x00	DWORD	Characteristics
					name	= "Characteristics";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= DEBUG_DIRECTRY_ENTRYCharacteristicsNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//					CharacteristicsItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(CharacteristicsItem);
					
					
					//0x04	DWORD	TimeDateStamp
					name	= "TimeDateStamp";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					Date date 	= new Date(Long.parseLong(value, 16)*1000);
					analysis	= date.toString();
					notes		= DEBUG_DIRECTRY_ENTRYTimeDateStampNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord TimeDateStamp					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> TimeDateStampItem	= new TreeItem<>(TimeDateStamp);
//					TimeDateStampItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(TimeDateStampItem);
					
					
					//0x08	WORD	MajorVersion
					name	= "MajorVersion";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= WORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= DEBUG_DIRECTRY_ENTRYMajorVersionNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord MajorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> MajorVersionItem	= new TreeItem<>(MajorVersion);
//					MajorVersionItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(MajorVersionItem);
						
					
					//0x0A	WORD	MinorVersion
					name	= "MinorVersion";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= WORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= DEBUG_DIRECTRY_ENTRYMinorVersionNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord MinorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> MinorVersionItem	= new TreeItem<>(MinorVersion);
//					MinorVersionItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(MinorVersionItem);
					
					
					//0x0C	DWORD	Type
					name	= "Type";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					if(value.equals("00000000")){
						analysis	= "IMAGE_DEBUG_TYPE_UNKNOWN(0x00000000)";
					}else if(value.equals("00000001")){
						analysis	= "IMAGE_DEBUG_TYPE_COFF(0x00000001)";
					}else if(value.equals("00000002")){
						analysis	= "IMAGE_DEBUG_TYPE_CODEVIEW(0x00000002)";
					}else if(value.equals("00000003")){
						analysis	= "IMAGE_DEBUG_TYPE_FPO(0x00000003)";
					}else if(value.equals("00000004")){
						analysis	= "IMAGE_DEBUG_TYPE_MISC(0x00000004)";
					}else if(value.equals("00000005")){
						analysis	= "IMAGE_DEBUG_TYPE_EXCEPTION(0x00000005)";
					}else if(value.equals("00000006")){
						analysis	= "IMAGE_DEBUG_TYPE_FIXUP(0x00000006)";
					}else if(value.equals("00000007")){
						analysis	= "IMAGE_DEBUG_TYPE_OMAP_TO_SRC(0x00000007)";
					}else if(value.equals("00000008")){
						analysis	= "IMAGE_DEBUG_TYPE_OMAP_FROM_SRC(0x00000008)";
					}else if(value.equals("00000009")){
						analysis	= "IMAGE_DEBUG_TYPE_BORLAND(0x00000009)";
					}else if(value.equals("0000000A")){
						analysis	= "IMAGE_DEBUG_TYPE_RESERVED10(0x0000000A)";
					}else if(value.equals("0000000B")){
						analysis	= "IMAGE_DEBUG_TYPE_CLSID(0x0000000B)";
					}
					notes		= DEBUG_DIRECTRY_ENTRYTypeNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord Type					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> TypeItem	= new TreeItem<>(Type);
//					TypeItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(TypeItem);
					
					
					//0x10	DWORD	SizeOfData
					name	= "SizeOfData";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";
					v			= getStringToInt(value, false);
					analysis	= String.valueOf(v)+" bytes";
					notes		= DEBUG_DIRECTRY_ENTRYSizeOfDataNotes;
					beforesize	= size;
					debugDataSize	= v;
					
					WinPE32TreeTableRecord SizeOfData				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> SizeOfDataItem	= new TreeItem<>(SizeOfData);
//					SizeOfDataItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(SizeOfDataItem);
					
					
					//0x14	DWORD	AddressOfRawData
					name	= "AddressOfRawData";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= DEBUG_DIRECTRY_ENTRYAddressOfRawDataNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord AddressOfRawData					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> AddressOfRawDataItem	= new TreeItem<>(AddressOfRawData);
//					AddressOfRawDataItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(AddressOfRawDataItem);

										
					//0x18	DWORD	PointerToRawData
					name	= "PointerToRawData";
					rawAddr	+= beforesize;
					raw		= rawAddr;
					offset	+= beforesize;
					rva		= startSectionRVA + offset;
					size	= DWORD;
					value	= "";
					for(int i=offset+size-1; i>=offset; i-- ){
						value	+= String.format("%02X", data[i]).toUpperCase();
					}
					analysis	= "";					
					notes		= DEBUG_DIRECTRY_ENTRYPointerToRawDataNotes;
					beforesize	= size;
					
					WinPE32TreeTableRecord PointerToRawData					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
					TreeItem<WinPE32TreeTableRecord> PointerToRawDataItem	= new TreeItem<>(PointerToRawData);
//					PointerToRawDataItem.setExpanded(true);
					IMAGE_DEBUG_DIRECTRYItem.getChildren().add(PointerToRawDataItem);
					
					
					//DEBUG_DATA作成
					makeDebugData(PointerToRawDataItem, value, debugDataSize);
					
				}
			}
		}	
	}

	private void makeDebugData(TreeItem<WinPE32TreeTableRecord> item, String strRawAddr, int debugDataSize) {
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;
		
		
		//どこのセクションにあるか？
		while(iterator.hasNext()){
			section	= (Section)iterator.next();
			
			//取得したセクションにデータがあれば作る
			if(getStringToInt(strRawAddr, false)>=section.getRawAddress() && getStringToInt(strRawAddr, false)+debugDataSize <= section.getRawAddress()+section.getRawSize()){
				
				//セクション情報取得
				startSectionRawAddr	= section.getRawAddress();
				sectionRawSize		= section.getRawSize();
				startSectionRVA		= section.getVirtualAddress();
				sectionRVASize		= section.getVirtualSize();
				addrDiff			= section.getDiff();
				
				//セクションデータ取得
				data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
				
				//開始アドレス設定
				rawAddr		= getStringToInt(strRawAddr, false);
				
				//データオフセット設定
				offset		= rawAddr - startSectionRawAddr;
				startOffset	= offset;
				beforesize	= 0;

				
				//DEBUG_DATA		
				name		= "DEBUG_DATA";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		+= beforesize;
				rva			= startSectionRVA + offset;
				size		= debugDataSize;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
				notes		= DEBUG_DATANotes;
				beforesize	= 0;
				baseOffset	= offset;
				
				WinPE32TreeTableRecord DEBUG_DATA					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DEBUG_DATAItem 	= new TreeItem<>(DEBUG_DATA);
//				DEBUG_DATAItem.setExpanded(true);
				item.getChildren().add(DEBUG_DATAItem);

			}
		}								
	}
	
	private void makeImageTlsDirectory(TreeItem<WinPE32TreeTableRecord> item) {
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;

		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_TLS_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_TLS_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_TLS_RVA, IMAGE_DIRECTORY_ENTRY_TLS_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_TLS_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;

					
					if(magicNumber.equals("010B")) {	//PE32
						
						//IMAGE_TLS_DIRECTORY		
						name		= "IMAGE_TLS_DIRECTORY";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= IMAGE_TLS_DIRECTORY32_SIZE;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_TLS_DIRECTORYNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_TLS_DIRECTORY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_TLS_DIRECTORYItem 	= new TreeItem<>(IMAGE_TLS_DIRECTORY);
//						IMAGE_TLS_DIRECTORYItem.setExpanded(true);
						item.getChildren().add(IMAGE_TLS_DIRECTORYItem);
					
					
						//0x00	DWORD	StartAddressOfRawData
						name	= "StartAddressOfRawData";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_TLS_DIRECTORYStartAddressOfRawDataNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord StartAddressOfRawData				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> StartAddressOfRawDataItem	= new TreeItem<>(StartAddressOfRawData);
//						StartAddressOfRawDataItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(StartAddressOfRawDataItem);

						
						//0x04	DWORD	EndAddressOfRawData
						name	= "EndAddressOfRawData";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_TLS_DIRECTORYEndAddressOfRawDataNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord EndAddressOfRawData					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> EndAddressOfRawDataItem	= new TreeItem<>(EndAddressOfRawData);
//						EndAddressOfRawDataItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(EndAddressOfRawDataItem);

						
						//0x08	DWORD	AddressOfIndex
						name	= "AddressOfIndex";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v);
						notes		= IMAGE_TLS_DIRECTORYAddressOfIndexNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord AddressOfIndex				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> AddressOfIndexItem	= new TreeItem<>(AddressOfIndex);
//						AddressOfIndexItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(AddressOfIndexItem);

						
						//0x0C	PIMAGE_TLS_CALLBACK	AddressOfCallBacks
						name	= "AddressOfCallBacks";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= PIMAGE_TLS_CALLBACK32_SIZE;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";				
						notes		= IMAGE_TLS_DIRECTORYAddressOfCallBacksNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord AddressOfCallBacks				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> AddressOfCallBacksItem	= new TreeItem<>(AddressOfCallBacks);
//						AddressOfCallBacksItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(AddressOfCallBacksItem);

						
						//0x10	DWORD	SizeOfZeroFill
						name	= "SizeOfZeroFill";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v)+" bytes";
						notes		= IMAGE_TLS_DIRECTORYSizeOfZeroFillNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SizeOfZeroFill				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SizeOfZeroFillItem	= new TreeItem<>(SizeOfZeroFill);
//						SizeOfZeroFillItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(SizeOfZeroFillItem);

						
						//0x14	DWORD	Characteristics
						name	= "Characteristics";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_TLS_DIRECTORYCharacteristicsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//						CharacteristicsItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(CharacteristicsItem);
						
					}else if(magicNumber.equals("020B")){	//PE32+
						
						//IMAGE_TLS_DIRECTORY		
						name		= "IMAGE_TLS_DIRECTORY";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= IMAGE_TLS_DIRECTORY64_SIZE;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_TLS_DIRECTORYNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_TLS_DIRECTORY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_TLS_DIRECTORYItem 	= new TreeItem<>(IMAGE_TLS_DIRECTORY);
//						IMAGE_TLS_DIRECTORYItem.setExpanded(true);
						item.getChildren().add(IMAGE_TLS_DIRECTORYItem);
					
					
						//0x00	ULONGLONG	StartAddressOfRawData
						name	= "StartAddressOfRawData";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_TLS_DIRECTORYStartAddressOfRawDataNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord StartAddressOfRawData				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> StartAddressOfRawDataItem	= new TreeItem<>(StartAddressOfRawData);
//						StartAddressOfRawDataItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(StartAddressOfRawDataItem);

						
						//0x08	ULONGLONG	EndAddressOfRawData
						name	= "EndAddressOfRawData";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_TLS_DIRECTORYEndAddressOfRawDataNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord EndAddressOfRawData					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> EndAddressOfRawDataItem	= new TreeItem<>(EndAddressOfRawData);
//						EndAddressOfRawDataItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(EndAddressOfRawDataItem);

						
						//0x10	ULONGLONG	AddressOfIndex
						name	= "AddressOfIndex";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						vl			= getStringToLong(value, false);
						analysis	= String.valueOf(vl);
						notes		= IMAGE_TLS_DIRECTORYAddressOfIndexNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord AddressOfIndex				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> AddressOfIndexItem	= new TreeItem<>(AddressOfIndex);
//						AddressOfIndexItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(AddressOfIndexItem);

						
						//0x18	PIMAGE_TLS_CALLBACK	AddressOfCallBacks
						name	= "AddressOfCallBacks";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= PIMAGE_TLS_CALLBACK64_SIZE;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";				
						notes		= IMAGE_TLS_DIRECTORYAddressOfCallBacksNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord AddressOfCallBacks				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> AddressOfCallBacksItem	= new TreeItem<>(AddressOfCallBacks);
//						AddressOfCallBacksItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(AddressOfCallBacksItem);

						
						//0x20	DWORD	SizeOfZeroFill
						name	= "SizeOfZeroFill";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v)+" bytes";
						notes		= IMAGE_TLS_DIRECTORYSizeOfZeroFillNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SizeOfZeroFill				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SizeOfZeroFillItem	= new TreeItem<>(SizeOfZeroFill);
//						SizeOfZeroFillItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(SizeOfZeroFillItem);

						
						//0x24	DWORD	Characteristics
						name	= "Characteristics";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_TLS_DIRECTORYCharacteristicsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//						CharacteristicsItem.setExpanded(true);
						IMAGE_TLS_DIRECTORYItem.getChildren().add(CharacteristicsItem);

					}					
				}
			}
		}
	}
	
	private void makeImageLoadConfigDirectory(TreeItem<WinPE32TreeTableRecord> item) {
		
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;
		
		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA, IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_LOAD_CONFIG_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;

					
					if(magicNumber.equals("010B")) {	//PE32
						
						//IMAGE_LOAD_CONFIG_DIRECTORY		
						name		= "IMAGE_LOAD_CONFIG_DIRECTORY";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= IMAGE_LOAD_CONFIG_DIRECTORY32_SIZE;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_LOAD_CONFIG_DIRECTORY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_LOAD_CONFIG_DIRECTORYItem 	= new TreeItem<>(IMAGE_LOAD_CONFIG_DIRECTORY);
//						IMAGE_LOAD_CONFIG_DIRECTORYItem.setExpanded(true);
						item.getChildren().add(IMAGE_LOAD_CONFIG_DIRECTORYItem);
					
					
						//0x00	DWORD	Characteristics
						name	= "Characteristics";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYCharacteristicsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//						CharacteristicsItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(CharacteristicsItem);

						
						//0x04	DWORD	TimeDateStamp
						name	= "TimeDateStamp";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						Date date 	= new Date(Long.parseLong(value, 16)*1000);
						analysis	= date.toString();
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYTimeDateStampNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord TimeDateStamp				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> TimeDateStampItem	= new TreeItem<>(TimeDateStamp);
//						TimeDateStampItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(TimeDateStampItem);						
						
						
						//0x08	WORD	MajorVersion
						name	= "MajorVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYMajorVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MajorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MajorVersionItem	= new TreeItem<>(MajorVersion);
//						MajorVersionItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(MajorVersionItem);
						
						
						//0x0a	WORD	MinorVersion
						name	= "MinorVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYMinorVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MinorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MinorVersionItem	= new TreeItem<>(MinorVersion);
//						MinorVersionItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(MinorVersionItem);
						
						
						//0x0c	DWORD	GlobalFlagsClear
						name	= "GlobalFlagsClear";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYGlobalFlagsClearNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord GlobalFlagsClear					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> GlobalFlagsClearItem	= new TreeItem<>(GlobalFlagsClear);
//						GlobalFlagsClearItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(GlobalFlagsClearItem);
						
						
						//0x10	DWORD	GlobalFlagsSet
						name	= "GlobalFlagsSet";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYGlobalFlagsSetNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord GlobalFlagsSet				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> GlobalFlagsSetItem	= new TreeItem<>(GlobalFlagsSet);
//						GlobalFlagsSetItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(GlobalFlagsSetItem);
						
						
						//0x14	DWORD	CriticalSectionDefaultTimeout
						name	= "CriticalSectionDefaultTimeout";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYCriticalSectionDefaultTimeoutNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord CriticalSectionDefaultTimeout				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CriticalSectionDefaultTimeoutItem	= new TreeItem<>(CriticalSectionDefaultTimeout);
//						CriticalSectionDefaultTimeoutItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(CriticalSectionDefaultTimeoutItem);
						
						
						//0x18	DWORD	DecommitFreeBloackThreshold
						name	= "DecommitFreeBloackThreshold";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";	
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYDecommitFreeBloackThresholdNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord DecommitFreeBloackThreshold					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> DecommitFreeBloackThresholdItem	= new TreeItem<>(DecommitFreeBloackThreshold);
//						DecommitFreeBloackThresholdItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(DecommitFreeBloackThresholdItem);
						
						
						//0x1c	DWORD	DecommitTotalFreeThreshold
						name	= "DecommitTotalFreeThreshold";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYDecommitTotalFreeThresholdNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord DecommitTotalFreeThreshold				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> DecommitTotalFreeThresholdItem	= new TreeItem<>(DecommitTotalFreeThreshold);
//						DecommitTotalFreeThresholdItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(DecommitTotalFreeThresholdItem);
						

						//0x20	DWORD	LockPrefixTable
						name	= "LockPrefixTable";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYLockPrefixTableNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord LockPrefixTable					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> LockPrefixTableItem	= new TreeItem<>(LockPrefixTable);
//						LockPrefixTableItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(LockPrefixTableItem);
						

						//0x24	DWORD	MaximumAllocationSize
						name	= "MaximumAllocationSize";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYMaximumAllocationSizeNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MaximumAllocationSize				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MaximumAllocationSizeItem	= new TreeItem<>(MaximumAllocationSize);
//						MaximumAllocationSizeItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(MaximumAllocationSizeItem);
						
						
						//0x28	DWORD	VirtualMemoryThreshold
						name	= "VirtualMemoryThreshold";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYVirtualMemoryThresholdNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord VirtualMemoryThreshold				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> VirtualMemoryThresholdItem	= new TreeItem<>(VirtualMemoryThreshold);
//						VirtualMemoryThresholdItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(VirtualMemoryThresholdItem);
						

						//0x2c	DWORD	ProcessHeapFlags
						name	= "ProcessHeapFlags";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYProcessHeapFlagsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord ProcessHeapFlags					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> ProcessHeapFlagsItem	= new TreeItem<>(ProcessHeapFlags);
//						ProcessHeapFlagsItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(ProcessHeapFlagsItem);

						
						//0x30	DWORD	ProcessAffinityMask
						name	= "ProcessAffinityMask";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";				
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYProcessAffinityMaskNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord ProcessAffinityMask					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> ProcessAffinityMaskItem	= new TreeItem<>(ProcessAffinityMask);
//						ProcessAffinityMaskItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(ProcessAffinityMaskItem);

						
						//0x34	WORD	CSDVersion
						name	= "CSDVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYCSDVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord CSDVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CSDVersionItem	= new TreeItem<>(CSDVersion);
//						CSDVersionItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(CSDVersionItem);
						

						//0x36	WORD	Reserved1
						name	= "Reserved1";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYReserved1Notes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Reserved1				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> Reserved1Item	= new TreeItem<>(Reserved1);
//						Reserved1Item.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(Reserved1Item);					
						
	
						//0x38	DWORD	EditList
						name	= "EditList";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYEditListNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord EditList					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> EditListItem	= new TreeItem<>(EditList);
//						EditListItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(EditListItem);	
						
						
						//0x3c	DWORD	SecurityCookie
						name	= "SecurityCookie";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYSecurityCookieNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SecurityCookie				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SecurityCookieItem	= new TreeItem<>(SecurityCookie);
//						SecurityCookieItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(SecurityCookieItem);
						
						
						//0x40	DWORD	SEHandlerTable
						name	= "SEHandlerTable";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYSEHandlerTableNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SEHandlerTable				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SEHandlerTableItem	= new TreeItem<>(SEHandlerTable);
//						SEHandlerTableItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(SEHandlerTableItem);
						
						
						//0x44	DWORD	SEHandlerCount
						name	= "SEHandlerCount";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v			= getStringToInt(value, false);
						analysis	= String.valueOf(v);
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYSEHandlerCountNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SEHandlerCount				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SEHandlerCountItem	= new TreeItem<>(SEHandlerCount);
//						SEHandlerCountItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(SEHandlerCountItem);
						
						
					}else if(magicNumber.equals("020B")){	//PE32+
						
						//IMAGE_LOAD_CONFIG_DIRECTORY		
						name		= "IMAGE_LOAD_CONFIG_DIRECTORY";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= IMAGE_LOAD_CONFIG_DIRECTORY64_SIZE;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_LOAD_CONFIG_DIRECTORY					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_LOAD_CONFIG_DIRECTORYItem 	= new TreeItem<>(IMAGE_LOAD_CONFIG_DIRECTORY);
//						IMAGE_LOAD_CONFIG_DIRECTORYItem.setExpanded(true);
						item.getChildren().add(IMAGE_LOAD_CONFIG_DIRECTORYItem);
					
					
						//0x00	DWORD	Characteristics
						name	= "Characteristics";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYCharacteristicsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Characteristics					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CharacteristicsItem	= new TreeItem<>(Characteristics);
//						CharacteristicsItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(CharacteristicsItem);

						
						//0x04	DWORD	TimeDateStamp
						name	= "TimeDateStamp";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						Date date 	= new Date(Long.parseLong(value, 16)*1000);
						analysis	= date.toString();
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYTimeDateStampNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord TimeDateStamp				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> TimeDateStampItem	= new TreeItem<>(TimeDateStamp);
//						TimeDateStampItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(TimeDateStampItem);						
						
						
						//0x08	WORD	MajorVersion
						name	= "MajorVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYMajorVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MajorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MajorVersionItem	= new TreeItem<>(MajorVersion);
//						MajorVersionItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(MajorVersionItem);
						
						
						//0x0a	WORD	MinorVersion
						name	= "MinorVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYMinorVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MinorVersion					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MinorVersionItem	= new TreeItem<>(MinorVersion);
//						MinorVersionItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(MinorVersionItem);
						
						
						//0x0c	DWORD	GlobalFlagsClear
						name	= "GlobalFlagsClear";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYGlobalFlagsClearNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord GlobalFlagsClear					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> GlobalFlagsClearItem	= new TreeItem<>(GlobalFlagsClear);
//						GlobalFlagsClearItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(GlobalFlagsClearItem);
						
						
						//0x10	DWORD	GlobalFlagsSet
						name	= "GlobalFlagsSet";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYGlobalFlagsSetNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord GlobalFlagsSet				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> GlobalFlagsSetItem	= new TreeItem<>(GlobalFlagsSet);
//						GlobalFlagsSetItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(GlobalFlagsSetItem);
						
						
						//0x14	DWORD	CriticalSectionDefaultTimeout
						name	= "CriticalSectionDefaultTimeout";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYCriticalSectionDefaultTimeoutNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord CriticalSectionDefaultTimeout				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CriticalSectionDefaultTimeoutItem	= new TreeItem<>(CriticalSectionDefaultTimeout);
//						CriticalSectionDefaultTimeoutItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(CriticalSectionDefaultTimeoutItem);
						
						
						//0x18	ULONGLONG	DecommitFreeBloackThreshold
						name	= "DecommitFreeBloackThreshold";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";	
						vl			= getStringToLong(value, false);
						analysis	= String.valueOf(vl)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYDecommitFreeBloackThresholdNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord DecommitFreeBloackThreshold					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> DecommitFreeBloackThresholdItem	= new TreeItem<>(DecommitFreeBloackThreshold);
//						DecommitFreeBloackThresholdItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(DecommitFreeBloackThresholdItem);
						
						
						//0x20	ULONGLONG	DecommitTotalFreeThreshold
						name	= "DecommitTotalFreeThreshold";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						vl			= getStringToLong(value, false);
						analysis	= String.valueOf(vl)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYDecommitTotalFreeThresholdNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord DecommitTotalFreeThreshold				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> DecommitTotalFreeThresholdItem	= new TreeItem<>(DecommitTotalFreeThreshold);
//						DecommitTotalFreeThresholdItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(DecommitTotalFreeThresholdItem);
						

						//0x28	ULONGLONG	LockPrefixTable
						name	= "LockPrefixTable";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYLockPrefixTableNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord LockPrefixTable					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> LockPrefixTableItem	= new TreeItem<>(LockPrefixTable);
//						LockPrefixTableItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(LockPrefixTableItem);
						

						//0x30	ULONGLONG	MaximumAllocationSize
						name	= "MaximumAllocationSize";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						vl			= getStringToLong(value, false);
						analysis	= String.valueOf(vl)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYMaximumAllocationSizeNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord MaximumAllocationSize				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> MaximumAllocationSizeItem	= new TreeItem<>(MaximumAllocationSize);
//						MaximumAllocationSizeItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(MaximumAllocationSizeItem);
						
						
						//0x38	ULONGLONG	VirtualMemoryThreshold
						name	= "VirtualMemoryThreshold";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						vl			= getStringToLong(value, false);
						analysis	= String.valueOf(vl)+ " bytes";
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYVirtualMemoryThresholdNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord VirtualMemoryThreshold				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> VirtualMemoryThresholdItem	= new TreeItem<>(VirtualMemoryThreshold);
//						VirtualMemoryThresholdItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(VirtualMemoryThresholdItem);
						
						
						//0x40	ULONGLONG	ProcessAffinityMask
						name	= "ProcessAffinityMask";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";				
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYProcessAffinityMaskNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord ProcessAffinityMask					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> ProcessAffinityMaskItem	= new TreeItem<>(ProcessAffinityMask);
//						ProcessAffinityMaskItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(ProcessAffinityMaskItem);


						//0x48	DWORD	ProcessHeapFlags
						name	= "ProcessHeapFlags";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYProcessHeapFlagsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord ProcessHeapFlags					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> ProcessHeapFlagsItem	= new TreeItem<>(ProcessHeapFlags);
//						ProcessHeapFlagsItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(ProcessHeapFlagsItem);


						//0x4c	WORD	CSDVersion
						name	= "CSDVersion";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYCSDVersionNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord CSDVersion				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> CSDVersionItem	= new TreeItem<>(CSDVersion);
//						CSDVersionItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(CSDVersionItem);
						

						//0x4e	WORD	Reserved1
						name	= "Reserved1";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= WORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYReserved1Notes;
						beforesize	= size;
						
						WinPE32TreeTableRecord Reserved1				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> Reserved1Item	= new TreeItem<>(Reserved1);
//						Reserved1Item.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(Reserved1Item);					
						
	
						//0x50	ULONGLONG	EditList
						name	= "EditList";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYEditListNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord EditList					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> EditListItem	= new TreeItem<>(EditList);
//						EditListItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(EditListItem);	

						
						//0x58	ULONGLONG	SecurityCookie
						name	= "SecurityCookie";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYSecurityCookieNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SecurityCookie				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SecurityCookieItem	= new TreeItem<>(SecurityCookie);
//						SecurityCookieItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(SecurityCookieItem);
						
						
						//0x60	ULONGLONG	SEHandlerTable
						name	= "SEHandlerTable";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYSEHandlerTableNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SEHandlerTable				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SEHandlerTableItem	= new TreeItem<>(SEHandlerTable);
//						SEHandlerTableItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(SEHandlerTableItem);
						
						
						//0x68	ULONGLONG	SEHandlerCount
						name	= "SEHandlerCount";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= ULONGLONG;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						vl			= getStringToLong(value, false);
						analysis	= String.valueOf(vl);
						notes		= IMAGE_LOAD_CONFIG_DIRECTORYSEHandlerCountNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord SEHandlerCount				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> SEHandlerCountItem	= new TreeItem<>(SEHandlerCount);
//						SEHandlerCountItem.setExpanded(true);
						IMAGE_LOAD_CONFIG_DIRECTORYItem.getChildren().add(SEHandlerCountItem);
						
							
					}			
				}	
			}
		}
	}
	
	private void makeImportAddressTable(TreeItem<WinPE32TreeTableRecord> item) {
	
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";
		short symbol	= 0;
		
		//カウント
		int count		= 0;
		int sizeCount	= 0;
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;
			
		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_IAT_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_IAT_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_IAT_RVA, IMAGE_DIRECTORY_ENTRY_IAT_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_IAT_RVA, false)-addrDiff;
					rva			= getStringToInt(IMAGE_DIRECTORY_ENTRY_IAT_RVA, false);
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;
					
					if(magicNumber.equals("010B")) {	//PE32
						
						while(sizeCount<IMAGE_DIRECTORY_ENTRY_IAT_RVA_SIZE){
							
							//IMPORT_ADDRESS_TABLE
							name		= "IMPORT_ADDRESS_TABLE"+"["+count+"]";
							rawAddr		+= beforesize;
							raw			= rawAddr;
							offset		+= beforesize;
							rva			+= beforesize;
							size		= IMAGE_THUNK_DATA32_SIZE;
							value		= "";
							analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
							notes		= IMPORT_ADDRESS_TABLENotes;
							beforesize	= 0;
							v			= 0;
							
							WinPE32TreeTableRecord IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
							TreeItem<WinPE32TreeTableRecord> IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(IMPORT_ADDRESS_TABLE);
//							IMPORT_ADDRESS_TABLEItem.setExpanded(true);
							item.getChildren().add(IMPORT_ADDRESS_TABLEItem);
							
							
							//0x00	DWORD	ForwarderString/Function/Ordinal/AddressOfData
							name	= "";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		+= beforesize;
							size	= DWORD;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";			
							v	= getStringToInt(value, false);			
							if((v & 0x80000000) != 0) { //Ordinalなら
								name	= "Ordinal";
								symbol	= (short)(v & 0xFFFF);
								analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
								notes		= IMPORT_ADDRESS_TABLEOrdinalNotes;
							}else {	//AddressOfDataなら
								name	= "AddressOfData";
								if(v != 0){
									v -= addrDiff;
									analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();
								}
								notes		= IMPORT_ADDRESS_TABLEAddressOfDataNotes;		
							}
							beforesize	= size;
							
							WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//							recordItem.setExpanded(true);
							IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);
							
							//IMAGE_IMPORT_BY_NAME作成			
							if((v & 0x80000000) == 0 && !value.equals("00000000")) { //AddressOfDataなら
								//アドレスはファイル内を示しているかチェック
								int lastLineno	= binTableRecordList.size()-1;
								int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
								int maxAddress	= lastLineno*16+lastByteNum;
								
								if(v<maxAddress){
									makeImageImportByName(recordItem, value, String.format("%08X", v).toUpperCase());
								}else{
									record.setCheck("*");
								}	
							}
							
							sizeCount	+= IMAGE_THUNK_DATA32_SIZE;
							
							count++;

						}
	
					}else if(magicNumber.equals("020B")){	//PE32+
						
						while(sizeCount<IMAGE_DIRECTORY_ENTRY_IAT_RVA_SIZE){
							
							//IMPORT_ADDRESS_TABLE
							name		= "IMPORT_ADDRESS_TABLE"+"["+count+"]";
							rawAddr		+= beforesize;
							raw			= rawAddr;
							offset		+= beforesize;
							rva			+= beforesize;
							size		= IMAGE_THUNK_DATA64_SIZE;
							value		= "";
							analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
							notes		= IMPORT_ADDRESS_TABLENotes;
							beforesize	= 0;
							
							WinPE32TreeTableRecord IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
							TreeItem<WinPE32TreeTableRecord> IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(IMPORT_ADDRESS_TABLE);
//							IMPORT_ADDRESS_TABLEItem.setExpanded(true);
							item.getChildren().add(IMPORT_ADDRESS_TABLEItem);
		
							
							//0x00	ULONGLONG	ForwarderString/Function/Ordinal/AddressOfData
							name	= "";
							rawAddr	+= beforesize;
							raw		= rawAddr;
							offset	+= beforesize;
							rva		= rva + beforesize;
							size	= ULONGLONG;
							value	= "";
							for(int i=offset+size-1; i>=offset; i-- ){
								value	+= String.format("%02X", data[i]).toUpperCase();
							}
							analysis	= "";
							vl	= getStringToLong(value, false);			
							if((vl & Long.MIN_VALUE) != 0) { //Ordinalなら
								name	= "Ordinal";
								symbol	= (short)(vl & 0xFFFF);
								analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
								notes		= IMPORT_ADDRESS_TABLEOrdinalNotes;
							}else {	//AddressOfDataなら
								name	= "AddressOfData";
								if(vl != 0){
									vl -= addrDiff;
									analysis	= "Raw=0x" + String.format("%016X", vl).toUpperCase();
								}
								notes		= IMPORT_ADDRESS_TABLEAddressOfDataNotes;
							}
							beforesize	= size;
							
							WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
							TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//							recordItem.setExpanded(true);
							IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);	
							
							//IMAGE_IMPORT_BY_NAME作成			
							if((vl & Long.MIN_VALUE) == 0 && !value.equals("0000000000000000")) { //Ordinalなら
								//アドレスはファイル内を示しているかチェック
								int lastLineno	= binTableRecordList.size()-1;
								int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
								long maxAddress	= lastLineno*16+lastByteNum;
								
								if(vl<maxAddress){
									makeImageImportByName(recordItem, value.substring(8, 16), String.format("%08X", vl).toUpperCase());
								}else{
									record.setCheck("*");
								}	
							}				
							
							sizeCount	+= IMAGE_THUNK_DATA64_SIZE;
							
							count++;	
							
						}
					}
				}
			}
		}
	}
	
	private void makeImageDelayImportDescriptor(TreeItem<WinPE32TreeTableRecord> item) {
	
		//セクション用変数
		Section section				= null;
		Iterator<Section> iterator	= sectionList.iterator();
		int startSectionRawAddr		= 0;
		int sectionRawSize			= 0;
		int startSectionRVA			= 0;
		int sectionRVASize			= 0;
		int addrDiff				= 0;
		
		//データ取得用変数
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int rva			= 0;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		String notes	= "";
		
		//カウント
		int count = 0;
		int sizeCount	= 0;
		
		//オフセット基準
		int startOffset	= 0;
		int baseOffset	= 0;
		
		
		//VirtualAddressおよびSizeはあるか？
		if(!IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA.equals("00000000") && IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA_SIZE!=0) {
						
			//どこのセクションにあるか？
			while(iterator.hasNext()){
				section	= (Section)iterator.next();
				
				//取得したセクションにデータがあれば作る
				if(section.addrCheck(IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA, IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA_SIZE)){
					
					//セクション情報取得
					startSectionRawAddr	= section.getRawAddress();
					sectionRawSize		= section.getRawSize();
					startSectionRVA		= section.getVirtualAddress();
					sectionRVASize		= section.getVirtualSize();
					addrDiff			= section.getDiff();
					
					//セクションデータ取得
					data		= getBintableBytes(startSectionRawAddr, sectionRawSize);
					
					//開始アドレス設定
					rawAddr		= getStringToInt(IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA, false)-addrDiff;
					
					//データオフセット設定
					offset		= rawAddr - startSectionRawAddr;
					startOffset	= offset;
					beforesize	= 0;

					while(sizeCount<IMAGE_DIRECTORY_ENTRY_DELAY_IMPORT_RVA_SIZE){
						
						//IMAGE_DELAY_IMPORT_DESCRIPTOR
						name		= "IMAGE_DELAY_IMPORT_DESCRIPTOR"+"["+count+"]";
						rawAddr		+= beforesize;
						raw			= rawAddr;
						offset		+= beforesize;
						rva			= startSectionRVA + offset;
						size		= IMAGE_DELAY_IMPORT_DESCRIPTOR_SIZE;
						value		= "";
						analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase()+"\n"+"SectionData="+section.getName();
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORNotes;
						beforesize	= 0;
						baseOffset	= offset;
						
						WinPE32TreeTableRecord IMAGE_DELAY_IMPORT_DESCRIPTOR				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-startOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
						TreeItem<WinPE32TreeTableRecord> IMAGE_DELAY_IMPORT_DESCRIPTORItem 	= new TreeItem<>(IMAGE_DELAY_IMPORT_DESCRIPTOR);
//						IMAGE_DELAY_IMPORT_DESCRIPTORItem.setExpanded(true);
						item.getChildren().add(IMAGE_DELAY_IMPORT_DESCRIPTORItem);
					
					
						//0x00	DWORD	grAttrs
						name	= "grAttrs";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";					
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORgrAttrsNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord grAttrs					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> grAttrsItem	= new TreeItem<>(grAttrs);
//						grAttrsItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(grAttrsItem);
		
			
						//0x04	DWORD	szName
						name	= "szName";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";	
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}			
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORszNameNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord szName					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> szNameItem	= new TreeItem<>(szName);
//						szNameItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(szNameItem);					
						
						//DLL_NAME作成
						if(!value.equals("00000000")){
							makeDelayImportDllName(szNameItem, value, String.format("%08X", v).toUpperCase());
						}
						

						//0x08	DWORD	phmod
						name	= "phmod";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}		
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORphmodNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord phmod				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> phmodItem	= new TreeItem<>(phmod);
//						phmodItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(phmodItem);
						
						
						//0x0c	DWORD	pIAT
						name	= "pIAT";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORpIATNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord pIAT					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> pIATItem	= new TreeItem<>(pIAT);
//						pIATItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(pIATItem);
								
						//DELAY_IMPORT_ADDRESS_TABLE作成
						if(!value.equals("00000000")){
							makeDelayImportAddressTable(pIATItem, value, String.format("%08X", v).toUpperCase());
						}
						
						
						//0x10	DWORD	pINT
						name	= "pINT";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORpINTNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord pINT					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> pINTItem	= new TreeItem<>(pINT);
//						pINTItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(pINTItem);
						
						//DELAY_IMPORT_NAME_TABLE作成
						if(!value.equals("00000000")){
							makeDelayImportNameTable(pINTItem, value, String.format("%08X", v).toUpperCase());
						}
						
						
						//0x14	DWORD	pBoundIAT
						name	= "pBoundIAT";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORpBoundIATNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord pBoundIAT				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> pBoundIATItem	= new TreeItem<>(pBoundIAT);
//						pBoundIATItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(pBoundIATItem);
						
						//DELAY_BOUND_IMPORT_ADDRESS_TABLE作成
						if(!value.equals("00000000")){
							makeDelayBoundImportAddressTable(pBoundIATItem, value, String.format("%08X", v).toUpperCase());
						}
						
						
						//0x18	DWORD	pUnloadIAT
						name	= "pUnloadIAT";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						v	= getStringToInt(value, false);
						if(v != 0){
							v -= addrDiff;
							analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();		
						}
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORpUnloadIATNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord pUnloadIAT				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> pUnloadIATItem	= new TreeItem<>(pUnloadIAT);
//						pUnloadIATItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(pUnloadIATItem);
					
						//DELAY_UNLOAD_IMPORT_ADDRESS_TABLE作成
						if(!value.equals("00000000")){
							makeDelayUnloadImportAddressTable(pUnloadIATItem, value, String.format("%08X", v).toUpperCase());
						}
						
					
						//0x1c	DWORD	dwTimeStamp
						name	= "dwTimeStamp";
						rawAddr	+= beforesize;
						raw		= rawAddr;
						offset	+= beforesize;
						rva		= startSectionRVA + offset;
						size	= DWORD;
						value	= "";
						for(int i=offset+size-1; i>=offset; i-- ){
							value	+= String.format("%02X", data[i]).toUpperCase();
						}
						analysis	= "";
						Date date 	= new Date(Long.parseLong(value, 16)*1000);
						analysis	= date.toString();
						notes		= IMAGE_DELAY_IMPORT_DESCRIPTORdwTimeStampNotes;
						beforesize	= size;
						
						WinPE32TreeTableRecord dwTimeStamp					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset-baseOffset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
						TreeItem<WinPE32TreeTableRecord> dwTimeStampItem	= new TreeItem<>(dwTimeStamp);
//						dwTimeStampItem.setExpanded(true);
						IMAGE_DELAY_IMPORT_DESCRIPTORItem.getChildren().add(dwTimeStampItem);

						//サイズ加算
						sizeCount	+= IMAGE_DELAY_IMPORT_DESCRIPTOR_SIZE;
						
						count++;
					}
				}
			}
		}		
	}
	
	private void makeDelayImportDllName(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr) {
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
//		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int raw			= 0;
		int rawAddr		= 0;
		int offset		= 0;
		int rva			= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
//		long vl			= 0;
		String notes	= "";
		int addr		= 0;
		
		//0x00	BYTE	DllName[1];
		name		= "DllName";
		rawAddr		= startRawAddr;
		raw			= rawAddr;
		offset		= offset + beforesize;
		rva			= startRVA;
		size		= 0;
		value		= "";
		analysis	= "";
		addr		= raw;
		do{
			//データ取得
			dataSize	= BYTE;
			data		= getBintableBytes(addr, dataSize);
			value		+= String.format("%02X", data[0]).toUpperCase();
			analysis	+= String.format("%c", data[0]);
			addr++;
			size++;
		}while(data[0] != 0);
		notes		= DELAY_IMPORTDllNameNotes;
		beforesize	= size;
		v			= 0;
		
		WinPE32TreeTableRecord DllName					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
		TreeItem<WinPE32TreeTableRecord> DllNameItem	= new TreeItem<>(DllName);
//		DllNameItem.setExpanded(true);
		item.getChildren().add(DllNameItem);	
		
	}
	
	private void makeDelayImportAddressTable(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= startRawAddr;
		int raw			= 0;
		int rva			= startRVA;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		int count		= 0;
		
		if(magicNumber.equals("010B")) {	//PE32
			
			dataSize	= IMAGE_THUNK_DATA32_SIZE;
			
//			do{									
				//DELAY_IMPORT_ADDRESS_TABLE
				name		= "DELAY_IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA32_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				v			= 0;
				
				WinPE32TreeTableRecord DELAY_IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(DELAY_IMPORT_ADDRESS_TABLE);
//				DELAY_IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	DWORD	Function
				name	= "Function";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		+= beforesize;
				size	= DWORD;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";
				v			= getStringToInt(value, false);
				notes		= DELAY_IMPORT_ADDRESS_TABLEFunctionNotes;
				beforesize	= size;
				
				WinPE32TreeTableRecord Function					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> FunctionItem	= new TreeItem<>(Function);
//				FunctionItem.setExpanded(true);
				DELAY_IMPORT_ADDRESS_TABLEItem.getChildren().add(FunctionItem);
				
//				//IMAGE_IMPORT_BY_NAME作成			
//				if(!value.equals("00000000")) {
//					//アドレスはファイル内を示しているかチェック
//					int lastLineno	= binTableRecordList.size()-1;
//					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
//					int maxAddress	= lastLineno*16+lastByteNum;			
//				
//					if(v<maxAddress){
//					makeImageImportByName(FunctionItem, value, String.format("%08X", v).toUpperCase());
//					}else{
//						Function.setCheck("*");
//					}
//				}
//				count++;
//				
//			}while(!value.equals("00000000"));

					
		}else if(magicNumber.equals("020B")){	//PE32+
			
			dataSize	= IMAGE_THUNK_DATA64_SIZE;
			
//			do{
				//DELAY_IMPORT_ADDRESS_TABLE
				name		= "DELAY_IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA64_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				
				WinPE32TreeTableRecord DELAY_IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(DELAY_IMPORT_ADDRESS_TABLE);
//				DELAY_IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	ULONGLONG	Function
				name	= "Function";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		= rva + beforesize;
				size	= ULONGLONG;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";
				vl			= getStringToLong(value, false);			
				notes		= DELAY_IMPORT_ADDRESS_TABLEFunctionNotes;
				beforesize	= size;
				
				WinPE32TreeTableRecord Function					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> FunctionItem	= new TreeItem<>(Function);
//				FunctionItem.setExpanded(true);
				DELAY_IMPORT_ADDRESS_TABLEItem.getChildren().add(FunctionItem);	
				
//				//IMAGE_IMPORT_BY_NAME作成			
//				if(!value.equals("0000000000000000")) {
//					//アドレスはファイル内を示しているかチェック
//					int lastLineno	= binTableRecordList.size()-1;
//					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
//					long maxAddress	= lastLineno*16+lastByteNum;			
//					
//					if(vl<maxAddress){
//						makeImageImportByName(FunctionItem, value.substring(8, 16), String.format("%08X", vl).toUpperCase());
//					}else{
//						Function.setCheck("*");
//					}
//				}
//				count++;	
//				
//			}while(!value.equals("0000000000000000"));
				
		}
	}
	
	private void makeDelayImportNameTable(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= startRawAddr;
		int raw			= 0;
		int rva			= startRVA;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		int count		= 0;
		
		if(magicNumber.equals("010B")) {	//PE32
			
			dataSize	= IMAGE_THUNK_DATA32_SIZE;
			
			do{									
				//DELAY_IMPORT_NAME_TABLE
				name		= "DELAY_IMPORT_NAME_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA32_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_IMPORT_NAME_TABLENotes;
				beforesize	= 0;
				v			= 0;
				
				WinPE32TreeTableRecord DELAY_IMPORT_NAME_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_IMPORT_NAME_TABLEItem 	= new TreeItem<>(DELAY_IMPORT_NAME_TABLE);
//				DELAY_IMPORT_NAME_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_IMPORT_NAME_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	DWORD	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		+= beforesize;
				size	= DWORD;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";			
				v	= getStringToInt(value, false);			
				if((v & 0x80000000) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(v & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= DELAY_IMPORT_NAME_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();
					}
					notes		= DELAY_IMPORT_NAME_TABLEAddressOfDataNotes;		
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				DELAY_IMPORT_NAME_TABLEItem.getChildren().add(recordItem);
				
				//IMAGE_IMPORT_BY_NAME作成			
				if((v & 0x80000000) == 0 && !value.equals("00000000")) { //AddressOfDataなら
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					int maxAddress	= lastLineno*16+lastByteNum;
					
					if(v<maxAddress){
						makeImageImportByName(recordItem, value, String.format("%08X", v).toUpperCase());
					}else{
						record.setCheck("*");
					}
				}				
				count++;
			}while(!value.equals("00000000"));
					
		}else if(magicNumber.equals("020B")){	//PE32+
			
			dataSize	= IMAGE_THUNK_DATA64_SIZE;
			
			do{
				//DELAY_IMPORT_NAME_TABLE
				name		= "DELAY_IMPORT_NAME_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA64_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_IMPORT_NAME_TABLENotes;
				beforesize	= 0;
				
				WinPE32TreeTableRecord DELAY_IMPORT_NAME_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_IMPORT_NAME_TABLEItem 	= new TreeItem<>(DELAY_IMPORT_NAME_TABLE);
//				DELAY_IMPORT_NAME_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_IMPORT_NAME_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	ULONGLONG	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		= rva + beforesize;
				size	= ULONGLONG;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";
				vl	= getStringToLong(value, false);			
				if((vl & Long.MIN_VALUE) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(vl & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= DELAY_IMPORT_NAME_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(vl != 0){
						vl -= addrDiff;
						analysis	= "Raw=0x" + String.format("%016X", vl).toUpperCase();
					}
					notes		= DELAY_IMPORT_NAME_TABLEAddressOfDataNotes;
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				DELAY_IMPORT_NAME_TABLEItem.getChildren().add(recordItem);	
				
				//IMAGE_IMPORT_BY_NAME作成			
				if((vl & Long.MIN_VALUE) == 0 && !value.equals("0000000000000000")) { //Ordinalなら
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					long maxAddress	= lastLineno*16+lastByteNum;
					
					if(vl<maxAddress){
						makeImageImportByName(recordItem, value.substring(8, 16), String.format("%08X", vl).toUpperCase());
					}else{
						record.setCheck("*");
					}
				}						
				count++;	
				
			}while(!value.equals("0000000000000000"));
		}
	}
	
	private void makeDelayBoundImportAddressTable(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= startRawAddr;
		int raw			= 0;
		int rva			= startRVA;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		int count		= 0;
		
		if(magicNumber.equals("010B")) {	//PE32
			
			dataSize	= IMAGE_THUNK_DATA32_SIZE;
			
			do{									
				//DELAY_BOUND_IMPORT_ADDRESS_TABLE
				name		= "DELAY_BOUND_IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA32_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_BOUND_IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				v			= 0;
				
				WinPE32TreeTableRecord DELAY_BOUND_IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_BOUND_IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(DELAY_BOUND_IMPORT_ADDRESS_TABLE);
//				DELAY_BOUND_IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_BOUND_IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
								
				//0x00	DWORD	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		+= beforesize;
				size	= DWORD;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";			
				v	= getStringToInt(value, false);			
				if((v & 0x80000000) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(v & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= DELAY_BOUND_IMPORT_ADDRESS_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();
					}
					notes		= DELAY_BOUND_IMPORT_ADDRESS_TABLEAddressOfDataNotes;		
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				DELAY_BOUND_IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);
					
				//IMAGE_IMPORT_BY_NAME作成			
				if(!value.equals("00000000")) {
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					int maxAddress	= lastLineno*16+lastByteNum;
					
					if(v<maxAddress){
						makeImageImportByName(recordItem, value, String.format("%08X", v).toUpperCase());
					}else{
						record.setCheck("*");
					}
				}		
				count++;
				
			}while(!value.equals("00000000"));
			
		}else if(magicNumber.equals("020B")){	//PE32+
			
			dataSize	= IMAGE_THUNK_DATA64_SIZE;
			
			do{
				//DELAY_BOUND_IMPORT_ADDRESS_TABLE
				name		= "DELAY_BOUND_IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA64_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_BOUND_IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				
				WinPE32TreeTableRecord DELAY_BOUND_IMPORT_ADDRESS_TABLE					= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_BOUND_IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(DELAY_BOUND_IMPORT_ADDRESS_TABLE);
//				DELAY_BOUND_IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_BOUND_IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	ULONGLONG	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		= rva + beforesize;
				size	= ULONGLONG;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";
				vl	= getStringToLong(value, false);			
				if((vl & Long.MIN_VALUE) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(vl & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= DELAY_BOUND_IMPORT_ADDRESS_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(vl != 0){
						vl -= addrDiff;
						analysis	= "Raw=0x" + String.format("%016X", vl).toUpperCase();
					}
					notes		= DELAY_BOUND_IMPORT_ADDRESS_TABLEAddressOfDataNotes;
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				DELAY_BOUND_IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);	
				
				//IMAGE_IMPORT_BY_NAME作成			
				if(!value.equals("0000000000000000")) {
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					long maxAddress	= lastLineno*16+lastByteNum;
					
					if(vl<maxAddress){
						makeImageImportByName(recordItem, value.substring(8, 16), String.format("%08X", vl).toUpperCase());
					}else{
						record.setCheck("*");
					}
				}							
				count++;	
				
			}while(!value.equals("0000000000000000"));
				
		}
	}
	
	private void makeDelayUnloadImportAddressTable(TreeItem<WinPE32TreeTableRecord> item, String strRVAAddr, String strRawAddr){
		
		//開始アドレス取得
		int startRawAddr		= getStringToInt(strRawAddr, false);
		int startRVA			= getStringToInt(strRVAAddr, false);	
		int addrDiff			= startRVA - startRawAddr;
				
		//データ取得用変数
		int dataSize	= 0;
		byte[] data		= null;
		
		//設定用変数
		String name		= "";
		int rawAddr		= startRawAddr;
		int raw			= 0;
		int rva			= startRVA;
		int offset		= 0;
		int beforesize	= 0;
		int size		= 0;
		String value	= "";
		String analysis	= "";
		int v			= 0;
		long vl			= 0;
		String notes	= "";	
		short symbol	= 0;
		int count		= 0;
		
		if(magicNumber.equals("010B")) {	//PE32
			
			dataSize	= IMAGE_THUNK_DATA32_SIZE;
			
			do{									
				//DELAY_UNLOAD_IMPORT_ADDRESS_TABLE
				name		= "DELAY_UNLOAD_IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA32_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_UNLOAD_IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				v			= 0;
				
				WinPE32TreeTableRecord DELAY_UNLOAD_IMPORT_ADDRESS_TABLE				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(DELAY_UNLOAD_IMPORT_ADDRESS_TABLE);
//				DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
								
				//0x00	DWORD	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		+= beforesize;
				size	= DWORD;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";			
				v	= getStringToInt(value, false);			
				if((v & 0x80000000) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(v & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= DELAY_UNLOAD_IMPORT_ADDRESS_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(v != 0){
						v -= addrDiff;
						analysis	= "Raw=0x" + String.format("%08X", v).toUpperCase();
					}
					notes		= DELAY_UNLOAD_IMPORT_ADDRESS_TABLEAddressOfDataNotes;		
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);
					
				//IMAGE_IMPORT_BY_NAME作成			
				if(!value.equals("00000000")) {
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					int maxAddress	= lastLineno*16+lastByteNum;
					
					if(v<maxAddress){
						makeImageImportByName(recordItem, value, String.format("%08X", v).toUpperCase());
					}else{
						record.setCheck("*");
					}
				}			
				count++;
				
			}while(!value.equals("00000000"));
					
		}else if(magicNumber.equals("020B")){	//PE32+
			
			dataSize	= IMAGE_THUNK_DATA64_SIZE;
			
			do{
				//DELAY_UNLOAD_IMPORT_ADDRESS_TABLE
				name		= "DELAY_UNLOAD_IMPORT_ADDRESS_TABLE"+"["+count+"]";
				rawAddr		+= beforesize;
				raw			= rawAddr;
				offset		= 0x0;
				rva			+= beforesize;
				size		= IMAGE_THUNK_DATA64_SIZE;
				value		= "";
				analysis	= "RVA-Raw=0x"+String.format("%08X", rva-raw).toUpperCase();
				notes		= DELAY_UNLOAD_IMPORT_ADDRESS_TABLENotes;
				beforesize	= 0;
				
				WinPE32TreeTableRecord DELAY_UNLOAD_IMPORT_ADDRESS_TABLE				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);
				TreeItem<WinPE32TreeTableRecord> DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem 	= new TreeItem<>(DELAY_UNLOAD_IMPORT_ADDRESS_TABLE);
//				DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem.setExpanded(true);
				item.getChildren().add(DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem);
								
				//データ取得		
				data		= getBintableBytes(rawAddr, dataSize);			
				
				//0x00	ULONGLONG	ForwarderString/Function/Ordinal/AddressOfData
				name	= "";
				rawAddr	+= beforesize;
				raw		= rawAddr;
				offset	+= beforesize;
				rva		= rva + beforesize;
				size	= ULONGLONG;
				value	= "";
				for(int i=offset+size-1; i>=offset; i-- ){
					value	+= String.format("%02X", data[i]).toUpperCase();
				}
				analysis	= "";
				vl	= getStringToLong(value, false);			
				if((vl & Long.MIN_VALUE) != 0) { //Ordinalなら
					name	= "Ordinal";
					symbol	= (short)(vl & 0xFFFF);
					analysis	= "Ordinal=" + String.format("%04X", symbol).toUpperCase();
					notes		= DELAY_UNLOAD_IMPORT_ADDRESS_TABLEOrdinalNotes;
				}else {	//AddressOfDataなら
					name	= "AddressOfData";
					if(vl != 0){
						vl -= addrDiff;
						analysis	= "Raw=0x" + String.format("%016X", vl).toUpperCase();
					}
					notes		= DELAY_UNLOAD_IMPORT_ADDRESS_TABLEAddressOfDataNotes;
				}
				beforesize	= size;
				
				WinPE32TreeTableRecord record				= new WinPE32TreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", rva).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, analysis, notes);		
				TreeItem<WinPE32TreeTableRecord> recordItem	= new TreeItem<>(record);
//				recordItem.setExpanded(true);
				DELAY_UNLOAD_IMPORT_ADDRESS_TABLEItem.getChildren().add(recordItem);	
				
				//IMAGE_IMPORT_BY_NAME作成			
				if(!value.equals("0000000000000000")) {
					//アドレスはファイル内を示しているかチェック
					int lastLineno	= binTableRecordList.size()-1;
					int lastByteNum	= binTableRecordList.get(lastLineno).getBlankColumnStartBinNumber();
					long maxAddress	= lastLineno*16+lastByteNum;
					
					if(vl<maxAddress){
						makeImageImportByName(recordItem, value.substring(8, 16), String.format("%08X", vl).toUpperCase());
					}else{
						record.setCheck("*");
					}
				}							
				count++;	
				
			}while(!value.equals("0000000000000000"));
				
		}
	}	
	
	private String getAddStrAddr(String strAddr1, boolean endian1, String strAddr2, boolean endian2) {
		
		int intAddr1	= getStringToInt(strAddr1, endian1);
		int intAddr2	= getStringToInt(strAddr2, endian2);
		int intAddr		= intAddr1 + intAddr2;
		String strAddr	= String.format("%08X", intAddr).toUpperCase();
		
		return strAddr;
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
		
//		System.out.println("str="+str);
//		System.out.println("little="+little);		
//		System.out.println("num="+num);
		
		return num;
	}
	
	private long getStringToLong(String str, boolean little) {
		
		long num 			= 0;
		byte[] bytes	 	= null;
		ByteBuffer bytesBuf = null;
		
		bytes	= DatatypeConverter.parseHexBinary(str);
		bytesBuf = ByteBuffer.wrap(bytes);
		
		if(little) {
			bytesBuf.order(ByteOrder.LITTLE_ENDIAN);
		}
		
		num	= bytesBuf.getLong(0);
		
//		System.out.println("str="+str);
//		System.out.println("little="+little);		
//		System.out.println("num="+num);
		
		return num;
	}
	
	private byte[] getBintableBytes(int startAddr, int size) {
		
//		byte[] startBytes = null;
//		ByteBuffer startBuf = null;
		
		int lineno		= 0;
		int offset		= 0;
		String dataStr	= null;
		byte[] data		= null;
		int datacount	= 0;
		
		//開始番地（文字列）を開始番地（数値）に変換する
//		startBytes	= DatatypeConverter.parseHexBinary(startStr);
//		startBuf = ByteBuffer.wrap(startBytes);
//		startBuf.order(ByteOrder.LITTLE_ENDIAN);
//		//System.out.println(startBuf.getInt(0));
		
		//開始番地からリストの開始行数とオフセットを求める
		lineno	= startAddr / 16;
		offset	= startAddr % 16;
		
//		System.out.println("lineno="+lineno);
//		System.out.println("offset="+offset);
		
		//バイナリのリストからデータを取得する		
		BinTableRecord binTableRecord 	= binTableRecordList.get(lineno);
		data	= new byte[size];
		
		if(offset+size >= 16) {	//次の行にまたがる場合
			//最初の1行
			for(int i=offset; i<16; i++){
				dataStr = binTableRecord.getBinData(i);
				data[datacount] = DatatypeConverter.parseHexBinary(dataStr)[0];				
				datacount++;
			}
			lineno++;
			
			//次の行から			
			while(datacount < size) {			
				binTableRecord 	= binTableRecordList.get(lineno);
				for(int j=0; j<16 ;j++){
//					System.out.println("lineno="+lineno);
//					System.out.println("j="+j);
//					System.out.println("datacount="+datacount);
//					System.out.println("size="+size);
					if(datacount < size) {
						dataStr = binTableRecord.getBinData(j);
						data[datacount] = DatatypeConverter.parseHexBinary(dataStr)[0];
						datacount++;
					}else {
						break;
					}
				}
				lineno++;
			}
			
		}else {
			//最初の1行
			for(int i=offset; i<offset+size; i++){
				dataStr = binTableRecord.getBinData(i);
				data[datacount]	= DatatypeConverter.parseHexBinary(dataStr)[0];
				datacount++;
			}		
		}

		return data;
	}
	
	
//	private void makeItem(byte[] data, String name, int raw, int offset, int size , String notes ,TreeItem<Win32PETreeTableRecord> item) {
//	
//	String value	= "";
//	for(int i=offset+size-1; i>=offset; i-- ){
//		value	+= String.format("%02X", data[i]).toUpperCase();
//	}
//	
//	Win32PETreeTableRecord record					= new Win32PETreeTableRecord(name, String.format("%08X", raw).toUpperCase(), String.format("%08X", offset).toUpperCase(), String.format("%08X", size).toUpperCase(), value, notes);		
//	TreeItem<Win32PETreeTableRecord> recordItem	= new TreeItem<>(record);
////	recordItem.setExpanded(true);
//	item.getChildren().add(recordItem);
//	
//}
	
	@FXML
	protected void onClose(ActionEvent evt) {
		System.exit(0);
	}
	
	@FXML
	protected void onReadMe(ActionEvent evt) {
		
		String alertType				= "INFORMATION";
		String title					= "ReadMe";
		String headerText				= "P+Viewer";
		String contentText				= "";
		String expandableContentText	= "";

		try {
			BufferedReader br		= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("ReadMe.txt")));			
			String str	= "";
			
			while((str = br.readLine()) != null) {
				contentText	+= str;
				contentText	+= "\n";
			}

			br.close();
		}catch(Exception e) {
			String message	= "An error occured.";	
			idConsole.setText(message);
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			alertMessageBox("ERROR", "ERROR", "ERROR", "An error occured.", sw.toString());
		}
		
		try {
			BufferedReader br		= new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Manual.txt")));			
			String str	= "";
			
			while((str = br.readLine()) != null) {
				expandableContentText	+= str;
				expandableContentText	+= "\n";
			}

			br.close();
		}catch(Exception e) {
			String message	= "An error occured.";	
			idConsole.setText(message);
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			alertMessageBox("ERROR", "ERROR", "ERROR", "An error occured.", sw.toString());
		}		
		
		alertMessageBox(alertType, title, headerText, contentText, expandableContentText);
		
	}
	
	@FXML
	protected void onInputKey(ActionEvent evt) {
		
		String title			= "Key Input";
		String headerText		= "Key Input";
		String contentText		= "Key:";
		String hash				= "2baf98674c17ac229b339e848376616f8344ead350a6887d0790dde50246a486";
		String potato			= "";
		
		TextInputDialog dialog	= new TextInputDialog();
		dialog.setTitle(title);
		dialog.setHeaderText(headerText);
		dialog.setContentText(contentText);
		
		Optional<String> result = dialog.showAndWait();
		
		if(result.isPresent()){
			potato				= toEncryptedHashValue("SHA-256", result.get());
			
			if(potato.equals(hash)){			
				//機能解放
				idFileExport.setDisable(false);
				idBinTable.setEditable(true);
				idRerun.setDisable(false);
			}
		}
	}
	
	private String toEncryptedHashValue(String algorithmName, String value) {
	    MessageDigest md = null;
	    StringBuilder sb = null;
	    try {
	        md = MessageDigest.getInstance(algorithmName);
	    } catch (NoSuchAlgorithmException e) {
			String message	= "An error occured.";	
			idConsole.setText(message);
			StringWriter sw	= new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			alertMessageBox("ERROR", "ERROR", "ERROR", "An error occured.", sw.toString());
	    }
	    md.update(value.getBytes());
	    sb = new StringBuilder();
	    for (byte b : md.digest()) {
	        String hex = String.format("%02x", b);
	        sb.append(hex);
	    }
	    return sb.toString();
	}
	
	private void alertMessageBox(String alertType, String title, String headerText, String contentText, String expandableContentText) {
		
		Alert alert;
		
		if(alertType.equals("INFORMATION")) {
			alert	= new Alert(AlertType.INFORMATION);
		}else if(alertType.equals("ERROR")){
			alert	= new Alert(AlertType.ERROR);
		}else if(alertType.equals("WARNING")){
			alert	= new Alert(AlertType.WARNING);
		}else {
			alert	= new Alert(AlertType.NONE);
		}
				
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(contentText);
		
		if(!expandableContentText.isEmpty()) {
			TextArea textArea	= new TextArea(expandableContentText);
			textArea.setEditable(false);
			alert.getDialogPane().setExpandableContent(textArea);
		}

		alert.setResizable(true);
		alert.getDialogPane().setPrefSize(600, 700);
		
		alert.showAndWait();
		
	}
	
}

