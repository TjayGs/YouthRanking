import { FC } from "react"

interface HeaderComponentProps {
  setShowPage: (page: string) => void
}

export const HeaderComponent: FC<HeaderComponentProps> = (props: HeaderComponentProps) => {
    const { setShowPage } = props
    return (
        <nav className='navbar' role={'navigation'} aria-label='main navigation'>
        <div className='navbar-brand'>
          <a className="navbar-item" onClick={() => setShowPage('home')}> YouthIntake</a>

          {/* TODO for what ? */}
          <a role="button" className="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
          </a>
        </div>
        <div id="navbar-main" className="navbar-menu">
          <div className="navbar-start">
            <a className="navbar-item" onClick={() => setShowPage('createPlayer')}>
              Erstelle Spieler
            </a>

            <a className="navbar-item" onClick={() => setShowPage('createSingleGame')}>
              Erstelle Einzel
            </a>

            <a className='navbar-item'>
              Erstelle Doppel
            </a>
          </div>
        </div>
        <div className="navbar-end">
        </div>
      </nav >
    )
}