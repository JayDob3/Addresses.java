/**
 *	Address.java
 *
 * 	Usage:
 *		java Address <page size> <address>
 *
 * 	For the given page size and virtual address, 
 * 	this program reports the page number and offset.
 */

public class Address
{
	public static final int ADDRESS_SIZE = 32;

	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("Usage: java Address <page size> <address>");
			System.exit(0);
		}
      /* Creates method to set the number pageSize and address */
		int pageSize = Integer.parseInt(args[0].trim());
		int address = Integer.parseInt(args[1].trim());

		int pageBits = 0;
		

		int pageMask = 0;
		int offsetMask = 0;

		/* Method to dispatch execution for the values of the pageSize, addresses, and offsets in a specific range */
      switch (pageSize) {
			case 1024:
				pageBits = 10;
				offsetMask = 0x000003ff;
				pageMask = 0xfffffc00;
				break;
			case 2048: 	
				pageBits = 11;
				offsetMask = 0x000007ff;
				pageMask = 0xfffff800;
				break;
			case 4096:
				pageBits = 12;
				offsetMask = 0x00000fff;
				pageMask = 0xfffff000;
                break;
            case 8192:
            	pageBits = 13;
            	offsetMask = 0x00001fff;
            	pageMask = 0xffffe000;
                break;
            case 16384:
            	pageBits = 14;
            	offsetMask = 0x00003fff;
            	pageMask = 0xffffcfff;
            	break;
		}
		

		int pageNumber = (address & pageMask) >> pageBits;
		int offset = (address & offsetMask);

      /* Method which prints the statement in regard to the page number 
      * and offset of the given virtual address with the specified page size */		
      System.out.println("For address " + address + " page number = " + pageNumber + " offset = " + offset);

	}
}
