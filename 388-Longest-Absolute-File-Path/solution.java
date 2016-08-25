import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
	public int lengthLongestPath(String input) {
		if (input == null || input.length() == 0) {
			return 0;
		}

		String[] dirs = input.split("\n");
		Dir[] paths = new Dir[dirs.length];
		for (int i = 0; i < dirs.length; i++) {
			paths[i] = new Dir(dirs[i]);
		}

		//System.out.println(Arrays.toString(paths));
		int max = 0;
		int length = 0;
		Deque<Dir> stack = new ArrayDeque<>();
		
		stack.push(paths[0]);
		length += paths[0].nameLen;
		if (stack.peek().isFile) {
			max = Math.max(max, length);
		}
		
		for (int i = 1; i < paths.length; i++) {
			Dir prevLevel = stack.peek();
			while (!stack.isEmpty() && paths[i].tabs <= prevLevel.tabs) {
				length -= (stack.pop().nameLen + 1);
				prevLevel = stack.peek();
			}
			length += (paths[i].nameLen + 1);
			stack.push(paths[i]);
			if (stack.peek().isFile) {
				max = Math.max(max, length);
			}
		}

		return max;
	}

	private class Dir {
		String fileName;
		int nameLen;
		int tabs;
		boolean isFile;

		public Dir(String file) {
			tabs = 0;
			while (file.startsWith("\t")) {
				tabs++;
				file = file.substring(1);
			}
			fileName = file;
			nameLen = fileName.length();
			isFile = fileName.contains(".");
		}
		@Override
		public String toString() {
			return fileName + " " +  tabs + " " + nameLen;
		}
	}
}