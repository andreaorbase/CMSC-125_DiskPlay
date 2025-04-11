import java.util.Collections;
import java.util.Vector;

class DiskAlgos {

  static int seek = 0;
  // static int size = 8;
  static int disk_size = 200;
  static int[] sequence;
  static int total_distance;

  // size is the number of elements in the array
  public static void setSize(int size) {
    // DiskAlgos.size = size;
  }

  public static void setDisk_size(int disk_size) {
    DiskAlgos.disk_size = disk_size;
  }

  public static int[] getSequence() {
    return sequence;
  }

  public static int getTotal_distance() {
    return total_distance;
  }

  public static void setTotal_distance(int total_distance) {
    DiskAlgos.total_distance = total_distance;
  }

  static int[] FCFS(int arr[], int head) {
    int size = arr.length;
    int seek_count = 0;
    int distance, cur_track;

    for (int i = 0; i < size; i++) {
      cur_track = arr[i];

      // calculate absolute distance
      distance = Math.abs(cur_track - head);

      // increase the total count
      seek_count += distance;

      // accessed track is now new head
      head = cur_track;
    }
    // Seek sequence would be the same
    // as request array sequence

    sequence = arr.clone();
    setTotal_distance(seek_count);
    // seek = seek_count;
    return sequence;
  }

  // Calculates difference of each track number with the head position
  public static void calculateDifference(int queue[], int head, Node diff[]) {
    for (int i = 0; i < diff.length; i++) diff[i].distance =
      Math.abs(queue[i] - head);
  }

  // find unaccessed track
  // which is at minimum distance from head
  public static int findMin(Node diff[]) {
    int index = -1, minimum = Integer.MAX_VALUE;

    for (int i = 0; i < diff.length; i++) {
      if (!diff[i].accessed && minimum > diff[i].distance) {
        minimum = diff[i].distance;
        index = i;
      }
    }
    return index;
  }

  public static int[] SSTF(int request[], int head) {
    // int size = request.length;
    if (request.length == 0) return request;

    // create array of objects of class node
    Node diff[] = new Node[request.length];

    // initialize array
    for (int i = 0; i < diff.length; i++) diff[i] = new Node();

    // count total number of seek operation
    int seek_count = 0;

    // stores sequence in which disk access is done
    int[] seek_sequence = new int[request.length + 1];

    for (int i = 0; i < request.length; i++) {
      seek_sequence[i] = head;
      calculateDifference(request, head, diff);

      int index = findMin(diff);

      diff[index].accessed = true;

      // increase the total count
      seek_count += diff[index].distance;

      // accessed track is now new head
      head = request[index];
    }

    // for last accessed track
    seek_sequence[seek_sequence.length - 1] = head;

    sequence = seek_sequence.clone();

    setTotal_distance(seek_count);
    seek = seek_count;
    return sequence;
  }

  static int[] SCAN(int arr[], int head, String direction) {
    int size = arr.length;
    int seek_count = 0;
    int distance, cur_track;
    Vector<Integer> left = new Vector<Integer>(), right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();

    // appending end values
    // which has to be visited
    // before reversing the direction
    if (direction == "left") left.add(0); else if (
      direction == "right"
    ) right.add(disk_size - 1);

    for (int i = 0; i < size; i++) {
      if (arr[i] < head) left.add(arr[i]);
      if (arr[i] > head) right.add(arr[i]);
    }

    // sorting left and right vectors
    Collections.sort(left);
    Collections.sort(right);

    // run the while loop two times.
    // one by one scanning right
    // and left of the head
    int run = 2;
    while (run-- > 0) {
      if (direction == "left") {
        for (int i = left.size() - 1; i >= 0; i--) {
          cur_track = left.get(i);

          // appending current track to seek sequence
          seek_sequence.add(cur_track);

          // calculate absolute distance
          distance = Math.abs(cur_track - head);

          // increase the total count
          seek_count += distance;

          // accessed track is now the new head
          head = cur_track;
        }
        direction = "right";
      } else if (direction == "right") {
        for (int i = 0; i < right.size(); i++) {
          cur_track = right.get(i);

          // appending current track to seek sequence
          seek_sequence.add(cur_track);

          // calculate absolute distance
          distance = Math.abs(cur_track - head);

          // increase the total count
          seek_count += distance;

          // accessed track is now new head
          head = cur_track;
        }
        direction = "left";
      }
      setTotal_distance(seek_count);
    }
    sequence = seek_sequence.stream().mapToInt(i -> i).toArray();
    seek = seek_count;
    return sequence;
  }

  public static int[] CSCAN(int arr[], int head) {
    int size = arr.length;
    int seek_count = 0;
    int distance, cur_track;

    Vector<Integer> left = new Vector<Integer>();
    Vector<Integer> right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();

    // Appending end values which has
    // to be visited before reversing
    // the direction
    left.add(0);
    right.add(disk_size - 1);

    // Tracks on the left of the
    // head will be serviced when
    // once the head comes back
    // to the beginning (left end).
    for (int i = 0; i < size; i++) {
      if (arr[i] < head) left.add(arr[i]);
      if (arr[i] > head) right.add(arr[i]);
    }

    // Sorting left and right vectors
    Collections.sort(left);
    Collections.sort(right);

    // First service the requests
    // on the right side of the
    // head.
    for (int i = 0; i < right.size(); i++) {
      cur_track = right.get(i);

      // Appending current track to seek sequence
      seek_sequence.add(cur_track);

      // Calculate absolute distance
      distance = Math.abs(cur_track - head);

      // Increase the total count
      seek_count += distance;

      // Accessed track is now new head
      head = cur_track;
    }

    // Once reached the right end
    // jump to the beginning.
    head = 0;

    // adding seek count for head returning from 199 to
    // 0
    seek_count += (disk_size - 1);

    // Now service the requests again
    // which are left.
    for (int i = 0; i < left.size(); i++) {
      cur_track = left.get(i);

      // Appending current track to
      // seek sequence
      seek_sequence.add(cur_track);

      // Calculate absolute distance
      distance = Math.abs(cur_track - head);

      // Increase the total count
      seek_count += distance;

      // Accessed track is now the new head
      head = cur_track;
    }
    sequence = seek_sequence.stream().mapToInt(i -> i).toArray();
    setTotal_distance(seek_count);
    seek = seek_count;
    return sequence;
  }

  public static int[] LOOK(int arr[], int head, String direction) {
    int size = arr.length;
    int seek_count = 0;
    int distance, cur_track;

    Vector<Integer> left = new Vector<Integer>();
    Vector<Integer> right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();

    // Appending values which are
    // currently at left and right
    // direction from the head.
    for (int i = 0; i < size; i++) {
      if (arr[i] < head) left.add(arr[i]);
      if (arr[i] > head) right.add(arr[i]);
    }

    // Sorting left and right vectors
    // for servicing tracks in the
    // correct sequence.
    Collections.sort(left);
    Collections.sort(right);

    // Run the while loop two times.
    // one by one scanning right
    // and left side of the head
    int run = 2;
    while (run-- > 0) {
      if (direction == "left") {
        for (int i = left.size() - 1; i >= 0; i--) {
          cur_track = left.get(i);

          // Appending current track to
          // seek sequence
          seek_sequence.add(cur_track);

          // Calculate absolute distance
          distance = Math.abs(cur_track - head);

          // Increase the total count
          seek_count += distance;

          // Accessed track is now the new head
          head = cur_track;
        }

        // Reversing the direction
        direction = "right";
      } else if (direction == "right") {
        for (int i = 0; i < right.size(); i++) {
          cur_track = right.get(i);

          // Appending current track to
          // seek sequence
          seek_sequence.add(cur_track);

          // Calculate absolute distance
          distance = Math.abs(cur_track - head);

          // Increase the total count
          seek_count += distance;

          // Accessed track is now new head
          head = cur_track;
        }

        // Reversing the direction
        direction = "left";
      }
    }

    sequence = seek_sequence.stream().mapToInt(i -> i).toArray();
    setTotal_distance(seek_count);
    return sequence;
  }

  public static int[] CLOOK(int arr[], int head) {
    int size = arr.length;
    int seek_count = 0;
    int distance, cur_track;

    Vector<Integer> left = new Vector<Integer>();
    Vector<Integer> right = new Vector<Integer>();
    Vector<Integer> seek_sequence = new Vector<Integer>();

    // Tracks on the left of the
    // head will be serviced when
    // once the head comes back
    // to the beginning (left end)
    for (int i = 0; i < size; i++) {
      if (arr[i] < head) left.add(arr[i]);
      // right bias for number in head
      if (arr[i] >= head) right.add(arr[i]);
    }

    // Sorting left and right vectors
    Collections.sort(left);
    Collections.sort(right);

    // First service the requests
    // on the right side of the
    // head
    for (int i = 0; i < right.size(); i++) {
      cur_track = right.get(i);

      // Appending current track
      // to seek sequence
      seek_sequence.add(cur_track);

      // Calculate absolute distance
      distance = Math.abs(cur_track - head);

      // Increase the total count
      seek_count += distance;

      // Accessed track is now new head
      head = cur_track;
    }

    // Once reached the right end
    // jump to the last track that
    // is needed to be serviced in
    // left direction
    if (left.size() > 0) {
      seek_count += Math.abs(head - left.get(0));
      head = left.get(0);
    }

    // Now service the requests again
    // which are left
    for (int i = 0; i < left.size(); i++) {
      cur_track = left.get(i);

      // Appending current track to
      // seek sequence
      seek_sequence.add(cur_track);

      // Calculate absolute distance
      distance = Math.abs(cur_track - head);

      // Increase the total count
      seek_count += distance;

      // Accessed track is now the new head
      head = cur_track;
    }

    // code for testing
    // for(int i = 0; i < seek_sequence.size(); i++){
    //    System.out.println(seek_sequence.get(i));
    //}

    //System.out.println("Total number of seek " +
    //                   "operations = " + seek_count);

    sequence = seek_sequence.stream().mapToInt(i -> i).toArray();
    setTotal_distance(seek_count);
    return sequence;
  }
}
