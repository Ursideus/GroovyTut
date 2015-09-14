package tut

class Phone {
  String dial(String num) {
    "Dialing $num"
  }
}

class Camera {
  String takePicture() {
    'Taking picture'
  }
}

class SmatrPhone {
  @delegate Phone phone = new Phone()
  @delegate Camera camera = new Camera()
}

SmatrPhone smartPhone = new SmartPhone()
assert smartPhone.dial('555555') == 'Dialing 555555'
assert smartPhone.takePicture() == 'Taking picture'
